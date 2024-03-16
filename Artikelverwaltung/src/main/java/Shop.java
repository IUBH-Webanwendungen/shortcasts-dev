import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class Shop implements Serializable
{
    private List<Artikel> sortiment = new ArrayList<Artikel>();

    public Shop()
    {

        sortiment.add(new Artikel(1, "Pantoffeln \"Rudolph\"",
                "Wunderschöne Filzpantoffeln, in beige Farbe mit einem braunen und schwarzen Kringel. Sehr angenehm für kalte Wintertage.",
                "filzschuhe.jpg", (new GregorianCalendar(2012, 11, 23).getTime())));
        sortiment.add(new Artikel(2, "Handtasche \"Cosmopolita\"",
                "Modische Filz-Handtasche mit praktischer Cocktailglas-Halterung. Irgendwie kommen wir nie aus dem Haus ohne solchen nützlichen Accessoire.",
                "handtasche.jpg", (new GregorianCalendar(2010, 10, 3).getTime())));
        sortiment.add(new Artikel(3, "Filz-Hase \"Moe\"",
                "Ein putziger Hase aus Filz zur Dekoration. Er lässt sich gern am Rand seines Büros stellen, um Mut zu geben.", "hase.jpg",
                (new GregorianCalendar(2013, 11, 31).getTime())));
    }

    public List<Artikel> getSortiment()
    {
        return sortiment;
    }
}
