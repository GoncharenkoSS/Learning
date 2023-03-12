package Lessons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        List<MusicBand> musicBands = new ArrayList<>();
        musicBands.add(new MusicBand("Nirvanna", 1982));
        musicBands.add(new MusicBand("Aria", 1981));
        musicBands.add(new MusicBand("RHCP", 1994));
        musicBands.add(new MusicBand("Papa Roach", 1996));
        musicBands.add(new MusicBand("Zemphira", 1997));
        musicBands.add(new MusicBand("Splin", 1999));
        musicBands.add(new MusicBand("Kino", 1986));
        musicBands.add(new MusicBand("Led Zeppelin", 1979));
        musicBands.add(new MusicBand("Iron Maiden", 1983));
        musicBands.add(new MusicBand("DDT", 1989));
        musicBands.add(new MusicBand("BI-2", 1995));
        musicBands.add(new MusicBand("GROB", 1986));

        System.out.println(musicBands);
        Collections.shuffle(musicBands);
        System.out.println(musicBands);
        MusicBand.groupsAfter1990(musicBands);
        System.out.println(musicBands);
    }

}
