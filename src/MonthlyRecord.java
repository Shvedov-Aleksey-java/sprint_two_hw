public class MonthlyRecord {
    private String itemName;
    private boolean isExpense;
    private int quantity;
    private double sumOfOne;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean getExpense() {
        return isExpense;
    }

    public void setExpense(boolean expense) {
        isExpense = expense;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSumOfOne() {
        return sumOfOne;
    }

    public void setSumOfOne(double sumOfOne) {
        this.sumOfOne = sumOfOne;
    }
}
