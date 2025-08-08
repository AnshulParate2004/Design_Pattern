package Prototype_Design_Patterns.TeacherStudents;


public class Main {
    public static void main(String[] args) {
        // Create prototype objects
        Student studentPrototype = new Student("Prototype Student", 20, "S000", "Computer Science");
        Teacher teacherPrototype = new Teacher("Prototype Teacher", 40, "T000", "Mathematics");

        // Clone students
        Student student1 = studentPrototype.clone();
        student1.setName("Alice");
        student1.setStudentId("S101");

        Student student2 = studentPrototype.clone();
        student2.setName("Bob");
        student2.setStudentId("S102");

        // Clone teachers
        Teacher teacher1 = teacherPrototype.clone();
        teacher1.setName("Dr. Smith");
        teacher1.setEmployeeId("T201");

        Teacher teacher2 = teacherPrototype.clone();
        teacher2.setName("Dr. Jane");
        teacher2.setEmployeeId("T202");

        // Display results
        student1.display();
        student2.display();
        teacher1.display();
        teacher2.display();
    }
}
