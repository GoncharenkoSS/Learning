package IMPUT_FILE;

import java.io.*;

public class Output {
    public static void main(String[] args) {
        FileWriter fos =null;
        String a = "\nHoly sheet";
        File file = new File("D:/2.txt");
        try {
            fos = new FileWriter(file, true);
            fos.write(a);
        } catch (IOException e) {
            e.printStackTrace();;
        }
        finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();;
            }
        }
    }
}
