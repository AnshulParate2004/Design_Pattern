package Composite;

public class Manager implements Employee {
    private final String name;
    private final double salary;

    public Manager(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String getName() { return name; }

    @Override
    public String getRole() { return "Manager"; }

    @Override
    public double getSalary() { return salary; }

    @Override
    public void print(String indent) {
        System.out.println(indent + "- " + getRole() + ": " + name + " (₹" + salary + ")");
    }
}
