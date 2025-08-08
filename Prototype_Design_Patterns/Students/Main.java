package Prototype_Design_Patterns.Students;

public class Main {
    public static void main(String[] args) {
        StudentRecord original = new StudentRecord(101, "Anshul", "RBU");

        System.out.println("Original Record:");
        original.showRecord();

        System.out.println("\nCloned Record:");
        StudentRecord clone = (StudentRecord) original.clone();
        clone.showRecord();
    }
}

