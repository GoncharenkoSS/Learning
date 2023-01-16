package Calorizator;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calorizator that = (Calorizator) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "\n" + name.toUpperCase() + ":\n" +
                "Калорийность - " + Kkal +
                "; Белки - " + Proteins +
                "; Жиры - " + Fats +
                "; Углеводы - " + Carbonitrates;
    }

}
