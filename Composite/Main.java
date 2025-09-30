package Composite;

public class Main {
    public static void main(String[] args) {
        Employee devA = new Developer("Aarav", 900000);
        Employee devB = new Developer("Meera", 1100000);
        Employee mgrEng = new Manager("Sanjay", 1600000);
        Employee qa = new Developer("Priya (QA)", 800000);
        Employee hrMgr = new Manager("Ritika (HR)", 1200000);

        Department engineering = new Department("Engineering");
        engineering.add(mgrEng);
        engineering.add(devA);
        engineering.add(devB);
        engineering.add(qa);

        Department hr = new Department("HR");
        hr.add(hrMgr);

        Department company = new Department("Acme Corp");
        company.add(engineering);
        company.add(hr);

        company.print("");

        System.out.println();
        System.out.println("Company total annual cost: ₹" + company.getSalary());
    }
}
