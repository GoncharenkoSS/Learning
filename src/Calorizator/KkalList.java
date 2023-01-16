package Calorizator;

import java.util.*;

public class KkalList {
    public static void main(String[] args) {
       List<Calorizator> list = new ArrayList<>();
       addElemebts(list);

        System.out.println("Добрый день!\nвы вошли в программу \"Колоризатор\"");
        System.out.println(       "__________________________________\n");
        while (true) {
            System.out.println("- Для расчета индекса массы тела нажмите - \"1\"");
            System.out.println("- Для расчета оптимального потребления калорий нажмите- \"2\"");
            System.out.println("- Введите название продукта что узнать его энергетическую ценность");
            System.out.println("- Чтобы отсортировать продукты:\n" +
                    "    - По калориям - \"3\"\n" +
                    "    - По белкам - \"4\"\n" +
                    "    - По жирам - \"5\"\n" +
                    "    - По углеводам - \"6\"");
            System.out.println("- Введите \"0\" для выхода");
            Scanner scanner = new Scanner(System.in);
            String digit = scanner.nextLine();
            if (digit.equals("1")) IMT();
            if (digit.equals("2")) BMR();
            if (digit.length() > 1) {
                Calorizator str = new Calorizator(digit, 0, 0, 0, 0);
                int index = list.indexOf(str);
                try {
                    System.out.println(list.get(index));
                } catch (Exception e) {
                    System.out.println("Такого продукта нет в списке");;
                }
                System.out.println("_______________________________");
            }
            if(digit.equals("3")) {
                list.sort(new Comparator<Calorizator>() {
                    @Override
                    public int compare(Calorizator o1, Calorizator o2) {
                        return Integer.compare(o1.getKkal(), o2.getKkal());
                    }
                });
                for (Calorizator i: list) {
                    System.out.println(i);
                }
                System.out.println("_______________________________");
            }
            if(digit.equals("4")) {
                list.sort(new Comparator<Calorizator>() {
                    @Override
                    public int compare(Calorizator o1, Calorizator o2) {
                        return Integer.compare(o1.getProteins(), o2.getProteins());
                    }
                });
                for (Calorizator i: list) {
                    System.out.println(i);
                }
                System.out.println("_______________________________");
            }
            if(digit.equals("5")) {
                list.sort(new Comparator<Calorizator>() {
                    @Override
                    public int compare(Calorizator o1, Calorizator o2) {
                        return Integer.compare(o1.getFats(), o2.getFats());
                    }
                });
                for (Calorizator i: list) {
                    System.out.println(i);
                }
                System.out.println("_______________________________");
            }
            if(digit.equals("6")) {
                list.sort(new Comparator<Calorizator>() {
                    @Override
                    public int compare(Calorizator o1, Calorizator o2) {
                        return Integer.compare(o1.getCarbonitrates(), o2.getCarbonitrates());
                    }
                });
                for (Calorizator i: list) {
                    System.out.println(i);
                }
                System.out.println("_______________________________");
            }
            if (digit.equals("0")) break;
        }
    }

public static void BMR(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Введите ваш пол\n" +"1 - Женщина\n" + "2 - Мужчина");
    int wc = sc.nextInt();
    System.out.println("Введите ваш вес(кг) и нажмите \"Enter\")");
    double w = sc.nextInt();
    System.out.println("Введите ваш рост(см) и нажмите \"Enter\")");
    double h = sc.nextInt();
    System.out.println("Введите ваш возраст и нажмите \"Enter\")");
    double y = sc.nextInt();
    double bmr=0;
    if(wc==2) bmr =88.36 + (13.4*w) + (4.8 * h)-(5.7*y);
    if(wc==1) bmr =447.6 + (9.2*w) + (3.1 * h)-(4.3*y);
    System.out.println("Ваша норма потребления каловий в сутки: " + Math.ceil(bmr) + " Kkal");
    System.out.println("______________________________________________");
}

public static void IMT(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Введите ваш вес(кг) и нажмите \"Enter\")");
    double w = sc.nextInt();
    System.out.println("Введите ваш рост(см) и нажмите \"Enter\")");
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
    System.out.println("_______________________________");
    }


    private static void addElemebts(Collection<Calorizator> collection) {
        collection.add(new Calorizator("курица", 113, 23, 2, 0));
        collection.add(new Calorizator("банан", 95, 2, 0, 22));
        collection.add(new Calorizator("творог", 121, 17, 5, 2));
        collection.add(new Calorizator("макароны", 359, 14, 2, 70));
        collection.add(new Calorizator("гречка", 350, 13, 3, 68));
        collection.add(new Calorizator("ментай", 79, 18, 1, 0));
        collection.add(new Calorizator("сахар", 398, 0, 0, 100));
        collection.add(new Calorizator("хлеб", 242, 8, 1, 49));
        collection.add(new Calorizator("яблоко", 47, 1, 1, 10));
        collection.add(new Calorizator("майонез", 629, 3, 67, 4));
        collection.add(new Calorizator("киноа", 368, 14, 6, 57));
        collection.add(new Calorizator("горох", 298, 20, 2, 53));
        collection.add(new Calorizator("рис", 322, 7, 0, 71));
        collection.add(new Calorizator("молоко", 64, 3, 3, 5));
        collection.add(new Calorizator("сметана", 158, 3, 15, 3));
        collection.add(new Calorizator("мандарин", 33, 1, 0, 8));
        collection.add(new Calorizator("картофель", 76, 2, 0, 16));
        collection.add(new Calorizator("печень", 135, 19, 6, 0));
        collection.add(new Calorizator("индейка", 84, 19, 1, 0));
        collection.add(new Calorizator("шоколад", 544, 5, 35, 56));
    }

}
