
import java.io.Serializable;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class ArtikelController implements Serializable
{
    @Inject
    Shop shop;

    private int index = 0;

    public Artikel getArtikel()
    {
        return shop.getSortiment().get(index);
    }

    public void vor()
    {
      if (index < shop.getSortiment().size() - 1) {
        index++;
      }
    }

    public void zurueck()
    {
      if (index > 0) {
        index--;
      }
    }

    public int getIndex()
    {
        return index;
    }
}
