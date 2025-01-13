package ss16_io_text_file.controller;

import ss16_io_text_file.service.StudentMng;
import ss16_io_text_file.view.Menu;
import ss16_io_text_file.view.Utils;

public class School extends Menu<String> {

    private static StudentMng std = new StudentMng();
    static String[] options = {
        "Add Student",
        "Display Student",
        "Sort student by name",
        "Count students in the same city",
        "Update student",
        "Delete student",
        "Report student",
        "Exit"
    };

    public School() {
        super("------------------Manage School----------------", options);
    }
    Utils data = new Utils();

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                addStudent();
                break;
            case 2:
                std.displayStudents();
                break;
            case 3:
                std.sortStudentsByName();
                break;
            case 4:                
                std.countStudentsByCity();
                break;
            case 5:
                std.updateStudent();
                break;
            case 6:                
                std.deleteStudent();
                break;
            case 7:
                std.reportStudents();
                break;
            case 8:
                System.exit(0);
            default:
                throw new AssertionError();
        }
    }

    private void addStudent() {
        String[] addOptions = {
            "Add IT Student",
            "Add Biz Student",
            "Exit"
        };

        Menu<String> addMenu = new Menu<String>("------------------Add Options----------------", addOptions) {
            @Override
            public void execute(int addChoice) {
                switch (addChoice) {
                    case 1:
                        std.addITStudent();
                        break;
                    case 2:
                        std.addBizStudent();
                        break;
                    case 3:
                        System.out.println("Exiting add student menu...");
                        main(options);
                    default:
                        System.out.println("Invalid choice, please try again");;
                }
            }
        };
        addMenu.run();
    }

    public static void main(String[] args) {
        School school = new School();
        school.run();
    }
}
