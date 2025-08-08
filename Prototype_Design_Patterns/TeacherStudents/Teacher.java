package Prototype_Design_Patterns.TeacherStudents;

public class Teacher extends Person {
    private String employeeId;
    private String subject;

    public Teacher() {}

    public Teacher(String name, int age, String employeeId, String subject) {
        super(name, age);
        this.employeeId = employeeId;
        this.subject = subject;
    }

    @Override
    public Teacher clone() {
        return (Teacher) super.clone();
    }

    @Override
    public void display() {
        System.out.println("Teacher(Name: " + name + ", Age: " + age +
                           ", Employee ID: " + employeeId + ", Subject: " + subject + ")");
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
