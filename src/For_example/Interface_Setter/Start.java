package For_example.Interface_Setter;
public class Start {

    public static void main(String[] args){
        Warehouse warehouse1 = new Warehouse();
        Warehouse warehouse2 = new Warehouse();

        Picker picker = new Picker();
        picker.setWarehouse(warehouse1);

        Picker picker2 = new Picker();
        picker2.setWarehouse(warehouse2);

        Courier courier = new Courier();
        courier.setWarehouse(warehouse1);

        Courier courier2 = new Courier();
        courier2.setWarehouse(warehouse2);

for(int i =0;i<10;i++) {
    picker.doWork();
    picker.bonus();
    courier.doWork();
    courier.bonus();

    picker2.doWork();
    picker2.bonus();
    courier2.doWork();
    courier2.bonus();
}
        System.out.println(warehouse1);
        System.out.println("Picker - " + picker.getSalary());
        System.out.println("Courier - " + courier.getSalary());
        System.out.println();
        System.out.println(warehouse2);
        System.out.println("Picker2 - " + picker2.getSalary());
        System.out.println("Courier2 - " + courier2.getSalary());
    }
}
