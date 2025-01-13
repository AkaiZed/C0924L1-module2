package ss16_io_text_file.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import ss16_io_text_file.model.Address;
import ss16_io_text_file.model.BizStudent;
import ss16_io_text_file.model.ITStudent;
import ss16_io_text_file.model.Student;
import ss16_io_text_file.view.Utils;

public class StudentMng implements IStudentMng {

    private ArrayList<Student> studentList = new ArrayList<>();

    public StudentMng() {
        loadData();
    }

    Utils data = new Utils();

    @Override
    public void loadData() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/ss16_io_text_file/Student.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(", ");

                String name = details[0];
                String id = details[1];
                String city = details[2];
                double score1 = Double.parseDouble(details[3]);
                double score2 = Double.parseDouble(details[4]);

                Address address = new Address(city);

                if (id.startsWith("IT")) {
                    ITStudent itStudent = new ITStudent(id, name, address, score1, score2);
                    studentList.add(itStudent);
                } else if (id.startsWith("BZ")) {
                    BizStudent bizStudent = new BizStudent(id, name, address, score1, score2);
                    studentList.add(bizStudent);
                }
            }
            System.out.println("Data loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    @Override
    public void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("There are no students in the list.");
            return;
        }

        System.out.printf("| %-7s | %-25s | %-10s | %-25s | %-7s |\n", "Id", "Full Name", "Address", "Score", "Avg");
        System.out.println("|----------------------------------------------------------------------------------------|");

        for (Student student : studentList) {
            String scores;
            if (student instanceof ITStudent) {
                ITStudent itStudent = (ITStudent) student;
                scores = String.format("java=%.1f, css=%.1f", itStudent.getJava(), itStudent.getCss());
            } else if (student instanceof BizStudent) {
                BizStudent bizStudent = (BizStudent) student;
                scores = String.format("acc=%.1f, mkt=%.1f", bizStudent.getAcc(), bizStudent.getMkt());
            } else {
                scores = "N/A";
            }

            System.out.printf("| %-7s | %-25s | %-10s | %-25s | %-7.3f |\n",
                    student.getId(),
                    student.getName(),
                    student.getAddress().getCity(),
                    scores,
                    student.calculateAvg());
        }
    }

    @Override
    public void sortStudentsByName() {
        if (studentList.isEmpty()) {
            System.out.println("There are no students to sort.");
            return;
        }
        studentList.sort((s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()));
        System.out.println("Students sorted by name:");
        displayStudents();
    }

    @Override
    public void countStudentsByCity() {
        displayStudents();
        String city = data.getName("Enter city name to count students: ");
        long count = studentList.stream()
                .filter(student -> student.getAddress().getCity().equalsIgnoreCase(city))
                .count();
        System.out.println("Number of students in " + city + ": " + count);
    }

    @Override
    public void updateStudent() {
        displayStudents();
        String id = data.getName("Enter student ID to update: ");
        for (Student student : studentList) {
            if (student.getId().equalsIgnoreCase(id)) {
                String newName = data.getName("Enter new name (press Enter to skip): ");
                if (!newName.isEmpty()) {
                    student.setName(newName);
                }

                String newCity = data.getName("Enter new city (press Enter to skip): ");
                if (!newCity.isEmpty()) {
                    student.getAddress().setCity(newCity);
                }

                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    @Override
    public void deleteStudent() {
        displayStudents();
        String id = data.getName("Enter student ID to delete: ");
        Student studentToRemove = null;
        for (Student student : studentList) {
            if (student.getId().equalsIgnoreCase(id)) {
                studentToRemove = student;
                break;
            }
        }
        if (studentToRemove != null) {
            studentList.remove(studentToRemove);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    @Override
    public void reportStudents() {
        System.out.println("Report of all students:");
        for (Student student : studentList) {
            String grade = student.calculateAvg() >= 5 ? "Passed" : "Failed";
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName() + ", Average: " + student.calculateAvg() + ", Grade: " + grade);
        }
    }

    @Override
    public void addITStudent() {
        String name = data.getName("Enter IT Student name: ");
        String id = data.checkIdIT("Enter the ID for the IT student(must be ITxxxx): ");
        Address address = getAddress();
        double java = data.getDouble("Enter Java score: ");
        double css = data.getDouble("Enter CSS score: ");
        ITStudent itStudent = new ITStudent(id, name, address, java, css);
        studentList.add(itStudent);
        System.out.println("IT Student added successfully.");
    }

    @Override
    public void addBizStudent() {
        String name = data.getName("Enter Biz Student name: ");
        String id = data.checkIdBiz("Enter the ID for the Biz student (must be BZxxxx): ");
        Address address = getAddress();
        double acc = data.getDouble("Enter Accounting score: ");
        double mkt = data.getDouble("Enter Marketing score: ");
        BizStudent bizStudent = new BizStudent(id, name, address, acc, mkt);
        studentList.add(bizStudent);
        System.out.println("Biz Student added successfully.");
    }

    private Address getAddress() {
        String city = data.getName("Enter the city: ");
        return new Address(city);
    }
}