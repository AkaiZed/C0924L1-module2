package ss5_static.build_class;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.toString());
        student.setClasses("C00");
        student.setName("Gin");
        System.out.println(student.toString());
    }
}
