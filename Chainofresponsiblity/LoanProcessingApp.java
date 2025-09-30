// Loan Request Object
class LoanRequest {
    double amount;
    int creditScore;
    double income;

    public LoanRequest(double amount, int creditScore, double income) {
        this.amount = amount;
        this.creditScore = creditScore;
        this.income = income;
    }
}

// Handler Interface
interface LoanHandler {
    void setNextHandler(LoanHandler nextHandler);
    void process(LoanRequest request);
}

// Step 1: Credit Score Check
class CreditScoreHandler implements LoanHandler {
    private LoanHandler next;

    @Override
    public void setNextHandler(LoanHandler nextHandler) {
        this.next = nextHandler;
    }

    @Override
    public void process(LoanRequest request) {
        if (request.creditScore < 650) {
            System.out.println("❌ Loan rejected: Credit score too low.");
            return;
        }
        System.out.println("✅ Credit score passed.");
        if (next != null) next.process(request);
    }
}

// Step 2: Income Check
class IncomeHandler implements LoanHandler {
    private LoanHandler next;

    @Override
    public void setNextHandler(LoanHandler nextHandler) {
        this.next = nextHandler;
    }

    @Override
    public void process(LoanRequest request) {
        if (request.income < 30000) {
            System.out.println("❌ Loan rejected: Income too low.");
            return;
        }
        System.out.println("✅ Income check passed.");
        if (next != null) next.process(request);
    }
}

// Step 3: Final Approval
class FinalApprovalHandler implements LoanHandler {
    private LoanHandler next; // not used, but for consistency

    @Override
    public void setNextHandler(LoanHandler nextHandler) {
        this.next = nextHandler;
    }

    @Override
    public void process(LoanRequest request) {
        System.out.println("🎉 Loan Approved for amount: " + request.amount);
    }
}

// Main Application
public class LoanProcessingApp {
    public static void main(String[] args) {
        LoanRequest request1 = new LoanRequest(50000, 700, 40000);
        LoanRequest request2 = new LoanRequest(20000, 600, 50000);

        // Build Chain
        LoanHandler credit = new CreditScoreHandler();
        LoanHandler income = new IncomeHandler();
        LoanHandler finalApproval = new FinalApprovalHandler();

        credit.setNextHandler(income);
        income.setNextHandler(finalApproval);

        System.out.println("Processing Request 1:");
        credit.process(request1);

        System.out.println("\nProcessing Request 2:");
        credit.process(request2);
    }
}
