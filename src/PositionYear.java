import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class PositionYear {
    private ArrayList<Integer> monthNumber;
    private ArrayList<Double> amount;
    private ArrayList<Boolean> isExpense;
    private int yearNumber;

    public ArrayList<Integer> getMonthNumber() {
        return monthNumber;
    }

    public ArrayList<Double> getAmount() {
        return amount;
    }

    public ArrayList<Boolean> getIsExpense() {
        return isExpense;
    }

    public int getYearNumber() {
        return yearNumber;
    }

    private String[] price;
    private String file;
    private String path;
    PositionYear(String path){
        this.path = path;
        monthNumber = new ArrayList<>();
        amount = new ArrayList<>();
        isExpense = new ArrayList<>();
        setClass();
    }
    private void setClass(){
        try {
            file = Files.readString(Path.of(this.path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с отчётом. Возможно файл не находится в нужной директории.");
        }
        this.price = this.file.split("\n");
        for (int i = 1; i < price.length; i++) {
            String[] position = price[i].split(", ");
            this.monthNumber.add(Integer.parseInt(position[0]));
            this.amount.add(Double.parseDouble(position[1]));
            this.isExpense.add(Boolean.parseBoolean(position[2]));
        }
        String[] reports = this.path.split("\\W");
        this.yearNumber = Integer.parseInt(reports[reports.length - 2]);

    }

}
