package For_example.TS_enum;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a = 0, b =0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("���������� ����������");
            System.out.println("     ������ ���:");
            String str = sc.nextLine().toUpperCase();
            if (str.equals("EXIT")) break;
            TS value = null;
            try {
                value = TS.valueOf(str);
            } catch (IllegalArgumentException e) {
                System.out.println("������� ������������ ��������");
                return;
            }
            for (TS elements : TS.values()) {
                if (value == elements) a = elements.ordinal();
                if (value != elements) b++;
            }
            TS ss = TS.values()[a];
            ss.GetData();

            System.out.println("\n������ EXIT ��� ������ \n");
        }
    }
}

