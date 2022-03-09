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
    private static Shop instance = new Shop();

    private List<Artikel> sortiment = new ArrayList<Artikel>();

    public Shop()
    {

        sortiment.add(new Artikel(1, "Pantoffeln \"Rudolph\"",
                "Wunderschöne Filzpantoffeln", "filzschuhe.jpg", (new GregorianCalendar(2012, 11, 23).getTime())));
        sortiment.add(new Artikel(2, "Handtasche \"Cosmopolita\"",
                "Modische Filz-Handtasche mit praktischer Cocktailglas-Halterung",
                "handtasche.jpg", (new GregorianCalendar(2010, 10, 3).getTime())));
        sortiment.add(new Artikel(3, "Filz-Hase \"Moe\"",
                "Ein putziger Hase aus Filz zur Dekoration", "hase.jpg",
                (new GregorianCalendar(2013, 11, 31).getTime())));
    }

    public static Shop getInstance()
    {
        return instance;
    }

    public List<Artikel> getSortiment()
    {
        return sortiment;
    }
}
