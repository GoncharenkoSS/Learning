package For_example.Interface;

public class Picker implements Worker {
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
        salary+=80;
        warehouse.setCountOrder(warehouse.getCountOrder()+1);
    }
    @Override
    public void bonus() {
        if(warehouse.getCountOrder()==1500) salary*=3;
    }
}
