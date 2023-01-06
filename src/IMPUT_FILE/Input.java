package IMPUT_FILE;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Input {
    public static void main(String[] args) {

        FileInputStream fis = null;
        InputStreamReader isr = null;
        int a = 0;

        try {
            fis = new FileInputStream("D:/1.txt");
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            while ((a = isr.read()) != -1) {
                System.out.print((char)a);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
