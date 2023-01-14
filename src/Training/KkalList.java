package Training;

import java.util.*;

public class KkalList {
    public static void main(String[] args) {
       List<Calorizator> list = new ArrayList<>();
       addElemebts(list);

        System.out.println("\n" + "Добрый день, вы вошли в программу \"Колоризатор\"" + "\n");

        System.out.println("Для расчета индекса массы тела нажмите - \"1\"");
        System.out.println("Для расчета оптимального потребления калорий нажмите- \"2\"");
        System.out.println("Введите название продукта что узнать его энергетическую ценность");
        System.out.println("Чтобы отсортировать продукты:\n" +
                "По белкам - \"Б\"\n" +
                "По жирам - \"Ж\"\n" +
                "По углеводам - \"У\"\n");
        Scanner scanner = new Scanner(System.in);
        int digit = scanner.nextInt();
        if(digit==1) IMT();
    }




































public static void IMT(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Введите ваш вес и затем рост(после ввода нажмите \"Enter\")");
    double w = sc.nextInt();
    double h = sc.nextInt();
    double x = w/(Math.pow((h/100), 2));
    String imt="";
    if(x<16) imt = "\"-Значительный дефецит массы тела\"";
    if(x<19 && x>16) imt = "\"-Дефецит массы тела\"";
    if(x<25 && x>19) imt = "\"-Норма\"";
    if(x<30 && x>25) imt = "\"-Лишний вес\"";
    if(x<35 && x>30) imt = "\"-Ожирение первой степени\"";
    if(x<40 && x>35) imt = "\"-Ожирение второй степени\"";
    if(x>40) imt = "\"-Ожирение третьей степени\"";
    System.out.println("Ваш индекс массы тела " + Math.ceil(x) + "\n" + imt);
    }


    private static void addElemebts(Collection collection) {
        collection.add(new Calorizator("Курица", 113, 23, 2, 0));
        collection.add(new Calorizator("Банан", 95, 2, 0, 22));
        collection.add(new Calorizator("Творог", 121, 17, 5, 2));
        collection.add(new Calorizator("Макароны", 359, 14, 2, 70));
        collection.add(new Calorizator("Гречка", 350, 13, 3, 68));
        collection.add(new Calorizator("Ментай", 79, 18, 1, 0));
        collection.add(new Calorizator("Сахар", 398, 0, 0, 100));
        collection.add(new Calorizator("Хлеб", 242, 8, 1, 49));
        collection.add(new Calorizator("Яблоко", 47, 1, 1, 10));
        collection.add(new Calorizator("Майонез", 629, 3, 67, 4));
        collection.add(new Calorizator("Киноа", 368, 14, 6, 57));
        collection.add(new Calorizator("Горох", 298, 20, 2, 53));
        collection.add(new Calorizator("Рис", 322, 7, 0, 71));
        collection.add(new Calorizator("Молоко", 64, 3, 3, 5));
        collection.add(new Calorizator("Сметана", 158, 3, 15, 3));
        collection.add(new Calorizator("Мандарин", 33, 1, 0, 8));
        collection.add(new Calorizator("Картофель", 76, 2, 0, 16));
        collection.add(new Calorizator("Печень", 135, 19, 6, 0));
        collection.add(new Calorizator("Индейка", 84, 19, 1, 0));
        collection.add(new Calorizator("Шоколад", 544, 5, 35, 56));
    }
}
