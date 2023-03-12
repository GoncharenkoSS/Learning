package Lessons;

import java.util.List;

public class MusicBand {
    private  String name;
    private  int year;

    public MusicBand(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static List<MusicBand> groupsAfter1990(List<MusicBand> bands){
        bands.removeIf(element -> element.getYear() < 1990);
            return bands;
    }

    @Override
    public String toString() {
        return "MusicBand{" +
                "name='" + name + '\'' +
                ", year=" + year +
                "}\n";
    }
}
