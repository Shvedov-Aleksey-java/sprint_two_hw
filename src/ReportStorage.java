import java.util.ArrayList;

public class ReportStorage {
    public ArrayList<MonthlyReport> monthlyReports;
    public ArrayList<YearlyReport> yearlyReports;

    public ReportStorage() {
        monthlyReports = new ArrayList<>();
        yearlyReports = new ArrayList<>();
    }
}
