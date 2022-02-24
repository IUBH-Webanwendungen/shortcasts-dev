public class Artikel
{
    private int nr;

    private String name;

    private String beschreibung;

    private String bild;

    public Artikel(int nr, String name, String beschreibung, String bild)
    {
        this.nr = nr;
        this.name = name;
        this.beschreibung = beschreibung;
        this.bild = bild;
    }

    public String getName()
    {
        return name;
    }

    public int getNr()
    {
        return nr;
    }

    public String getBeschreibung()
    {
        return beschreibung;
    }

    public String getBild()
    {
        return bild;
    }
}
