import java.util.ArrayList;

public class MonthlyRecord {
    private String itemName;
    private Boolean isExpense;
    private Integer quantity;
    private Double sumOfOne;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Boolean getExpense() {
        return isExpense;
    }

    public void setExpense(Boolean expense) {
        isExpense = expense;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSumOfOne() {
        return sumOfOne;
    }

    public void setSumOfOne(Double sumOfOne) {
        this.sumOfOne = sumOfOne;
    }
}
