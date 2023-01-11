package Training;

import java.util.*;

public class List {
    public static void main(String[] args) {
        Random RRR = new Random();
        java.util.List<Integer> list = new ArrayList<>();
        for(int i=1;i<40;i++) {
            list.add(RRR.nextInt(40));
        }
        System.out.println(list);
    }
}
