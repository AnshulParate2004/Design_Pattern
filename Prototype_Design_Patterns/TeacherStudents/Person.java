package Prototype_Design_Patterns.TeacherStudents;

public abstract class Person implements Cloneable {
    protected String name;
    protected int age;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Prototype method as abstract
    @Override
    public abstract Person clone();

    public abstract void display();
}
