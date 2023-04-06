import java.util.ArrayList;

public class YearlyReport {
    ReportingMethods methods = new ReportingMethods();
    private String price;
    private String report;
    private ArrayList<PositionYear> positions;

    public String getPrice() {
        return price;
    }

    private boolean yearY;
    private int year;
    private String expansion;

    public boolean isYearY() {
        return yearY;
    }

    public int getYear() {
        return year;
    }

    public String getExpansion() {
        return expansion;
    }

    public String getReport() {
        return report;
    }

    public ArrayList<PositionYear> getPositions() {
        return positions;
    }

    public YearlyReport(String report) {
        determinant(report);
        this.report = report;
        this.price = methods.readFileContents(report);
        positions = new ArrayList<>();
        distribution(this.price);


    }

    private void distribution(String price){
        String[] prices = price.split("\n");
        for (int i = 1; i < prices.length; i++) {
            String[] bumm = prices[i].split(", ");
            this.positions.add(new PositionYear());
            positions.get(i - 1).setMonth(Integer.parseInt(bumm[0]));
            positions.get(i - 1).setAmount(Double.parseDouble(bumm[1]));
            positions.get(i - 1).setExpense(Boolean.parseBoolean(bumm[2]));

        }
    }
    private void determinant(String report){
        String[] reports = report.split("[.]");
        if (reports[0].equals("y"))this.yearY = true;
        this.year = Integer.parseInt(reports[1]);
        this.expansion = reports[2];

    }
}
