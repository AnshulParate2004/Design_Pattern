package Prototype_Design_Patterns.TeacherStudents;

public abstract class Person implements Cloneable {
    protected String name;
    protected int age;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Prototype method
    @Override
    public Person clone() {
        try {
            return (Person) super.clone(); // shallow copy
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public abstract void display();
}

