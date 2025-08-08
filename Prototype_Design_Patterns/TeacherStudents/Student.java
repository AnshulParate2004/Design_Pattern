package Prototype_Design_Patterns.TeacherStudents;

public class Student extends Person {
    private String studentId;
    private String course;

    public Student() {}

    public Student(String name, int age, String studentId, String course) {
        super(name, age);
        this.studentId = studentId;
        this.course = course;
    }

    @Override
    public Student clone() {
        return (Student) super.clone(); // Shallow copy is fine for this simple class
    }

    @Override
    public void display() {
        System.out.println("Student(Name: " + name + ", Age: " + age + 
                           ", ID: " + studentId + ", Course: " + course + ")");
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
