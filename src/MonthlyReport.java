import java.util.ArrayList;

public class MonthlyReport {
    ReportingMethods methods = new ReportingMethods();
    private String report;
    private ArrayList<PositionMonth> positions;
    private boolean monthM;
    private int monthNumber;
    private int year;
    private String expansion;
    private String price;

    public ArrayList<PositionMonth> getPositions() {
        return positions;
    }
    public String getReport() {
        return report;
    }

    public boolean isMonthM() {
        return monthM;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public int getYear() {
        return year;
    }

    public String getExpansion() {
        return expansion;
    }

    public MonthlyReport(String report) {
        determinant(report);
        this.report = report;
        this.price = methods.readFileContents(report);
        this.positions = new ArrayList<>();
        distribution(this.price);
    }

    private void distribution(String price){
        String[] prices = price.split("\n");
        for (int i = 1; i < prices.length; i++) {
            String[] bumm = prices[i].split(", ");
            this.positions.add(new PositionMonth());
            positions.get(i - 1).setItemName(bumm[0]);
            positions.get(i - 1).setExpense(Boolean.parseBoolean(bumm[1]));
            positions.get(i - 1).setQuantity(Integer.parseInt(bumm[2]));
            positions.get(i - 1).setSumOfOne(Double.parseDouble(bumm[3]));
        }
    }

    private void determinant(String report){
        String[] reports = report.split("[.]");
        String monthNumber = "";
        String year = "";
        if (reports[0].equals("m"))this.monthM = true;
        for (int i = 0; i < reports[1].length(); i++) {
            char s = reports[1].charAt(i);
            if (i < 4){
                year += String.valueOf(s);
            }else {
                monthNumber += String.valueOf(s);
            }
        }
        this.expansion = reports[2];
        this.monthNumber = Integer.parseInt(monthNumber);
        this.year = Integer.parseInt(year);
    }
}
