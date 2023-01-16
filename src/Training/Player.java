package Training;

public class Player {
private int stamina;
public final int MIN_STAMINA = 0;
public final int MAX_STAMINA = 100;
public static int countPlayers;

    public Player(int stamina) {
        this.stamina = stamina;
        if(countPlayers<6) countPlayers++;
    }

    public int getStamina() {
        return stamina;
    }
    public void run(){
       if(stamina==0) return;
       stamina--;
       if(stamina==0) countPlayers--;
    }
    public static void info(){
        if (countPlayers<6) {
            System.out.println("Команды не полные, еще есть " + (6 - countPlayers) + " свободных мест");
        }else {
            System.out.println("Мест больше нет");
        }
    }
}
