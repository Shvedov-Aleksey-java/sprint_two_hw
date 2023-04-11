import java.util.ArrayList;

public class YearlyReport {
    private int year;
    private ArrayList<YearlyRecord> records;

    YearlyReport(){
        records = new ArrayList<>();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<YearlyRecord> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<YearlyRecord> records) {
        this.records = records;
    }
}
