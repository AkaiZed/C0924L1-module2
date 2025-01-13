
package ss16_io_text_file.service;

import ss16_io_text_file.model.Student;
import java.util.ArrayList;

public interface IStudentMng {
    void loadData();
    void displayStudents();
    void sortStudentsByName();
    void countStudentsByCity();
    void updateStudent();
    void deleteStudent();
    void reportStudents();
    void addITStudent();
    void addBizStudent();
}