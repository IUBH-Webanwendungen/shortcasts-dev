import java.util.ArrayList;
import java.util.Collection;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class Shop
{
    private Collection<Artikel> sortiment = new ArrayList<Artikel>();

    /**
     * Creates a new instance of Shop
     */
    public Shop()
    {
        sortiment.add(new Artikel(1, "Pantoffeln \"Rudolph\"",
                "Wunderschöne Filzpantoffeln", "filzschuhe.jpg"));
        sortiment.add(new Artikel(2, "Handtasche \"Cosmopolita\"",
                "Modische Filz-Handtasche mit praktischer Cocktailglas-Halterung",
                "handtasche.jpg"));
        sortiment.add(new Artikel(3, "Filz-Hasen \"Moe & Joe\"",
                "Ein putziger Hase aus Filz zur Dekoration", "hase.jpg"));
    }

    public Collection<Artikel> getSortiment()
    {
        return sortiment;
    }
}
