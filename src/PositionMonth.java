import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class PositionMonth {
    private ArrayList<String> itemName;
    private ArrayList<Boolean> isExpense;
    private ArrayList<Integer> quantity;
    private ArrayList<Double> sumOfOne;
    private int monthNumber;
    private int yearNumber;

    public ArrayList<String> getItemName() {
        return itemName;
    }

    public ArrayList<Boolean> getIsExpense() {
        return isExpense;
    }

    public ArrayList<Integer> getQuantity() {
        return quantity;
    }

    public ArrayList<Double> getSumOfOne() {
        return sumOfOne;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public int getYearNumber() {
        return yearNumber;
    }

    private String[] price;
    private String year = "";
    private String month = "";
    private String file;
    private String path;
    PositionMonth(String path){
        this.path = path;
        itemName = new ArrayList<>();
        isExpense = new ArrayList<>();
        quantity = new ArrayList<>();
        sumOfOne = new ArrayList<>();
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
            this.itemName.add(position[0]);
            this.isExpense.add(Boolean.parseBoolean(position[1]));
            this.quantity.add(Integer.parseInt(position[2]));
            this.sumOfOne.add(Double.parseDouble(position[3]));
        }

        String[] reports = this.path.split("\\W");
        for (int i = 0; i < reports[reports.length - 2].length(); i++) {
            char s = reports[reports.length - 2].charAt(i);
            if (i < 4){
                this.year += String.valueOf(s);
            }else {
                this.month += String.valueOf(s);
            }
        }
        this.monthNumber = Integer.parseInt(month);
        this.yearNumber = Integer.parseInt(year);

    }
}
