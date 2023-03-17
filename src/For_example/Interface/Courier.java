package For_example.Interface;


public class Courier implements Worker {
    private int salary;
    private Warehouse warehouse;


    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public void doWork() {
        salary = salary+100;
        warehouse.setBalance(warehouse.getBalance()+1000);
    }

    @Override
    public void bonus() {
        if(warehouse.getBalance()==1000000) salary*=2;
    }
}
