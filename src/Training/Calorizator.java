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

    @Override
    public String toString() {
        return "Calorizator{" +
                "name='" + name + '\'' +
                ", Kkal=" + Kkal +
                ", Proteins=" + Proteins +
                ", Fats=" + Fats +
                ", Carbonitrates=" + Carbonitrates +
                '}' + "\n";
    }
}
