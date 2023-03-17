package For_example;

public class Recursion {
    static int count = 0; static int sum=0;
    public static void main(String[] args) {

        int [] numbers = { 22 , 10 , 1241 , 50402 , - 50 , 249 , 10215 , 665 , 2295 , 7 , 311 };

        System.out.println(recursionSum(numbers, 0));
    }

    /////// счетчики в рекурсии не работают!!!
    public static int recursionSum(int[] numbers, int n){
        if (numbers.length == n)
            return 0;
        return recursionSum(numbers, n+1) + numbers[n];
    }
}