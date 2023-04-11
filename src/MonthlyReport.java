import java.util.ArrayList;

public class MonthlyReport {
    private int year;
    private int month;
    private double monthlyExpense = 0;
    private double monthlyIncome = 0;
    private ArrayList<MonthlyRecord> records;

    MonthlyReport(){
         records = new ArrayList<>();
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public double getMonthlyExpense() {
        return monthlyExpense;
    }

    public void setMonthlyExpense(double monthlyExpense) {
        this.monthlyExpense = monthlyExpense;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public ArrayList<MonthlyRecord> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<MonthlyRecord> records) {
        this.records = records;
    }
}
