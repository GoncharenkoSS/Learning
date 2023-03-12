package For_example.TasksOOP;
import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 5;
        Train[] trains = new Train[n];
        trains[0] = new Train("Msk", 122, "12:42");
        trains[1] = new Train("Msk", 123, "12:45");
        trains[2] = new Train("Spb", 34, "23:08");
        trains[3] = new Train("Msk", 33, "12:42");
        trains[4] = new Train("Spb", 156, "05:44");
        while (true) {
            System.out.println(
                    "Выберете пункт меню:" + "\n" +
                            "1. сортировка по номерам поездов" + "\n" +
                            "2. вывод информации о поезде по номеру" + "\n" +
                            "3. сортировка по пункту назначения" + "\n" +
                            "4. вывод всех поездов" + "\n" +
                            "5. выход" + "\n"
            );
            int choice = scanner.nextInt();
            if (choice == 5)
                break;
            if (choice < 1 || choice > 5) {
                System.out.println("выбран неправильный пункт меню, повторите ввод.");
                continue;
            }
            switch (choice) {
                case 1:
                    Arrays.sort(trains, new Train.ByNumberComparator());
                    break;
                case 2:
                    System.out.println("введи индекс поезда: ");
                    int pos = scanner.nextInt();
                    if (pos < 0 || pos >= trains.length)
                        System.out.println("выбран неправильный номер элемента массива");
                    else
                        trains[pos].print();
                    break;
                case 3:
                    Arrays.sort(trains, new Train.ByDestinationAndTimeComparator());
                    break;
                case 4:
                    for (int i = 0; i < trains.length; ++i) {
                        System.out.print(i + " ");
                        trains[i].print();
                    }
                    break;
            }
        }

    }
}