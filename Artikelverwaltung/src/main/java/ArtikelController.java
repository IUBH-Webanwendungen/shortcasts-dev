import java.io.Serializable;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class ArtikelController implements Serializable
{
    private int index = 0;

    public Artikel getArtikel()
    {
        return Shop.getInstance().getSortiment().get(index);
    }

    public void vor()
    {
      if (index < Shop.getInstance().getSortiment().size() - 1) {
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
