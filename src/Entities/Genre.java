package Entities;

import javax.xml.bind.annotation.XmlAttribute;

public class Genre
{
    //Fields :
    private int id;
    private String name;

    //Constructor :
    public Genre(int identity,String nameGenre)
    {
        setId(identity);
        setName(nameGenre);
    }

    //Setters :

    @XmlAttribute(name = "idGenre")
    public int getId()
    {
        return id;
    }
    public void setId(int identity)
    {
        id = identity;
    }

    @XmlAttribute(name = "nameGenre")
    public String getName()
    {
        return name;
    }
    public void setName(String nameGenre)
    {
        name = nameGenre;
    }
}
