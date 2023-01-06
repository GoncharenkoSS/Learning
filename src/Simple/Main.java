package Simple;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("Dog");
        Human human = new Human("Homo");
        Bird bird =new Bird("Crow");

        System.out.println(animal.hashCode()+2);
        System.out.println(animal.name + animal.hashCode());
        System.out.println(human.name + human.hashCode());
        System.out.println(bird.name + bird.hashCode());
        System.out.println();
    }

    static class Animal{
        String name;

        public Animal(String name) {
            this.name = name;
        }
    }
    static class Human{
        String name;

        public Human(String name) {
            this.name = name;
        }
    }
    static class Bird{
        String name;

        public Bird(String name) {
            this.name = name;
        }
    }
}
