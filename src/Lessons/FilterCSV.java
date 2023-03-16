package Lessons;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FilterCSV {
    public static void main(String[] args) {
        BufferedReader reader;
        FileInputStream fis;
        List<Items> item = new ArrayList<>();
        String[] arr;

        try {
            fis = new FileInputStream("shoes.csv");
            reader = new BufferedReader(new InputStreamReader(fis, StandardCharsets.UTF_8));

            String line = reader.readLine();

            while (line != null) {
                arr = line.split(";");

                if (Integer.parseInt(arr[2]) == 0)
                    item.add(new Items(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2])));

                line = reader.readLine();
            }
            reader.close();

            System.out.println(item);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FileWriter writer;
        String text;
        try {
            writer = new FileWriter("filter.csv", false);

            for (Items items : item) {
                text = items.name() + ";" + items.size() + ";" + items.quantity() + "\n";
                writer.write(text);
            }

            writer.flush();
        } catch (IOException ex) {
            System.out.println("File not found");
        }
    }

    record Items(String name, int size, int quantity) {

        @Override
            public String toString() {
                return "\nItems: " + name + " " +
                        "size: " + size + " " +
                        "quantity: " + quantity;
            }
        }
}


