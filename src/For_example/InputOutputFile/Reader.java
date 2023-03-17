package For_example.InputOutputFile;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public static void main(String[] args) {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("people.txt"));

            List<People> person = new ArrayList<>();

            String[] arr;

            String line = reader.readLine();

            while (line != null) {

                arr = line.split(" ");

                    if(Integer.parseInt(arr[1])>0)
                person.add(new People(arr[0], Integer.parseInt(arr[1])));
                    else throw new FactorialException("Возраст человека должен быть юольше ноля");

                line = reader.readLine();
            }

            reader.close();

            System.out.println(person);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException | FactorialException e) {
            throw new RuntimeException(e);
        }
    }


    static class People {
        private String name;
        private int age;

        public People(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " - " + age;
        }
    }

    static class FactorialException extends Exception {
        public FactorialException(String message){
            super(message);
        }
    }
}
