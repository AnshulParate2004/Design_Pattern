package Composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department implements Employee {
    private final String name;
    private final List<Employee> members = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void add(Employee e) { members.add(e); }
    public void remove(Employee e) { members.remove(e); }
    public List<Employee> getMembers() { return Collections.unmodifiableList(members); }

    @Override
    public String getName() { return name; }

    @Override
    public String getRole() { return "Department"; }

    @Override
    public double getSalary() {
        return members.stream().mapToDouble(Employee::getSalary).sum();
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "+ Department: " + name + " (Total Cost: ₹" + getSalary() + ")");
        String childIndent = indent + "  ";
        for (Employee e : members) {
            e.print(childIndent);
        }
    }
}
