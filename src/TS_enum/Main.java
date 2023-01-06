package TS_enum;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a = 0, b =0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("ТЕЛЕФОННЫЙ СПРАВОЧНИК");
            System.out.println("     Ведите Имя:");
            String str = sc.nextLine().toUpperCase();
            if (str.equals("EXIT")) break;
            TS value = null;
            try {
                value = TS.valueOf(str);
            } catch (IllegalArgumentException e) {
                System.out.println("Введено неккоректное значение");
                return;
            }
            for (TS elements : TS.values()) {
                if (value == elements) a = elements.ordinal();
                if (value != elements) b++;
            }
            TS ss = TS.values()[a];
            ss.GetData();

            System.out.println("\nВедите EXIT для выхода \n");
        }
    }
}

