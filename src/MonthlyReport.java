import java.util.ArrayList;

public class MonthlyReport {
    private int year;
    private int month;
    private ArrayList<MonthlyRecord> records;

    MonthlyReport(){
         records = new ArrayList<>();
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
