package Training;

public class Practics {
    public static void main(String[] args) {
    Player one = new Player(91);
    Player two = new Player(92);
    Player four = new Player(94);
    Player.info();
    Player six = new Player(96);
    Player seven = new Player(97);
    Player nine = new Player(99);
    Player.info();

        System.out.println(nine.getStamina());
    for(int i=0;i< nine.getStamina();i++) nine.run();
        Player.info();
        System.out.println(nine.getStamina());
    }
}
