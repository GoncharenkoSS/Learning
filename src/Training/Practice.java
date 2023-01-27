package Training;

import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
     int[] arr = new int[20];
     for (int i =0;i<20;i++) arr[i]=i;
     arr = Arrays.stream(arr).map(a -> a*34).toArray();
        System.out.println(Arrays.toString(arr));
    }
}
