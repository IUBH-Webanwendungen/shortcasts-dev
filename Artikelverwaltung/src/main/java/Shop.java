import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.checkerframework.checker.units.qual.Current;

@Named
@ApplicationScoped
public class Shop implements Serializable
{
    private final List<Artikel> sortiment = new ArrayList<Artikel>();

    private final String[][] users =
            new String[][]{
                    new String[]{"koch", "i-am-the-boss", "admin"},
                    new String[]{"you", "you-are-the-client", "client"}
            };

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


    void validateUsernameAndPassword(CurrentUser currentUser, String name,String pass) {
        currentUser.reset();
        for(String[] user: users) {
            if(user[0].equals(name)) {
                if(user[1].equals(pass)) {
                    if(user[2].equals("admin")) {
                        currentUser.admin = true; return;
                    } else if(user[2].equals("client")) {
                        currentUser.client = true; return;
                    }
                    else throw new RuntimeException("Benutzer " + name + " ist falsch angelegt.");
                }
            }
        }
    }
}
