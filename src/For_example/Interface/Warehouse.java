package For_example.Interface;

public class Warehouse {
    private int countOrder =0;
    private int balance =0;

    public int getCountOrder() {
        return countOrder;
    }

    public void setCountOrder(int countOrder) {
        this.countOrder = countOrder;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Количество собранных заказов - " + countOrder +
                "\nДоход от доставленных заказов - " + balance;
    }
}
