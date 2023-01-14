package Training;

public class Calorizator {
private  String name;
private  int Kkal;
private  int Proteins;
private  int Fats;
private int Carbonitrates;

    public Calorizator(String name, int kkal, int proteins, int fats, int carbonitrates) {
        this.name = name;
        Kkal = kkal;
        Proteins = proteins;
        Fats = fats;
        Carbonitrates = carbonitrates;
    }

    public String getName() {
        return name;
    }

    public int getKkal() {
        return Kkal;
    }

    public int getProteins() {
        return Proteins;
    }

    public int getFats() {
        return Fats;
    }

    public int getCarbonitrates() {
        return Carbonitrates;
    }

}
