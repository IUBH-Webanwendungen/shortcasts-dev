import java.io.Serializable;
import java.util.Date;

public class Artikel implements Serializable
{
    private int nr;

    private String name;

    private String text;

    private String bild;

    private Date verfuegbarAb;

    public Artikel()
    {
    }

    public Artikel(int nr, String name, String text, String bild)
    {
        this(nr, name, text, bild, new Date(0));
    }

    public Artikel(int nr, String name, String text, String bild, Date verfuegbarAb)
    {
        this.nr = nr;
        this.name = name;
        this.text = text;
        this.bild = bild;
        this.verfuegbarAb = verfuegbarAb;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getNr()
    {
        return nr;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public String getBild()
    {
        return bild;
    }

    public void setBild(String bild)
    {
        this.bild = bild;
    }

    public Date getVerfuegbarAb()
    {
        return verfuegbarAb;
    }

    public void setVerfuegbarAb(Date verfuegbarAb)
    {
        this.verfuegbarAb = verfuegbarAb;
    }
}
