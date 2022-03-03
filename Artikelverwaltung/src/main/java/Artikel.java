public class Artikel
{
    private int nr;

    private String name;

    private String text;

    private String bild;

    public Artikel(int nr, String name, String text, String bild)
    {
        this.nr = nr;
        this.setName(name);
        this.setText(text);
        this.setBild(bild);
    }

    public String getName()
    {
        return name;
    }

    public int getNr()
    {
        return nr;
    }

    public String getText()
    {
        return text;
    }

    public String getBild()
    {
        return bild;
    }

	public void setName(String name) {
		this.name = name;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setBild(String bild) {
		this.bild = bild;
	}
}
