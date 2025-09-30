abstract class DataProcessor {

    public final void process() {
        readData();
        processData();
        saveData();
    }

    void readData() {
        System.out.println("Reading data from source...");
    }

    abstract void processData();

    void saveData() {
        System.out.println("Saving processed data to storage...");
    }
}

class ExcelDataProcessor extends DataProcessor {
    @Override
    void processData() {
        System.out.println("Processing data from Excel file...");
    }
}

class DatabaseDataProcessor extends DataProcessor {
    @Override
    void processData() {
        System.out.println("Processing data from Database...");
    }
}

// Client code
public class TemplatePatternExample {
    public static void main(String[] args) {
        DataProcessor excel = new ExcelDataProcessor();
        excel.process();

        System.out.println("------");

        DataProcessor db = new DatabaseDataProcessor();
        db.process();
    }
}
