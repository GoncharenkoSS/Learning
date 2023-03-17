package For_example;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        int [][] field = new int[10][10];
        for(int i=0;i<field.length;i++){
            for (int j=0;j<field[i].length;j++){
                field[i][j]=(i+1) * (j+1);
            }
        }
        System.out.println((char)27 +"[4m                                                 ");
        for(int i=0;i<field.length;i++){
            for (int j=0;j<field[i].length;j++){
                if(field[i][j]/10 < 1)
                    System.out.print(field[i][j] + "  | ");
                else
                    System.out.print(field[i][j] + " | ");
            }
            System.out.println();
    }
    }
}
