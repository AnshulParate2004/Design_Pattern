package Prototype_Design_Patterns.TeacherStudents;

public class Main {
    public static void main(String[] args) {
        // Create original Student
        Student s1 = new Student("Alice", 20, "S101", "Computer Science");
        s1.display();

        // Clone Student
        Student s2 = s1.clone();
        s2.setName("Bob");
        s2.setStudentId("S102");
        s2.display();

        System.out.println();

        // Create original Teacher
        Teacher t1 = new Teacher("Mr. Smith", 45, "T201", "Mathematics");
        t1.display();

        // Clone Teacher
        Teacher t2 = t1.clone();
        t2.setName("Mrs. Johnson");
        t2.setEmployeeId("T202");
        t2.display();
    }
}
