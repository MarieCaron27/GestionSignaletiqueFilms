package Entities;

import javax.xml.bind.annotation.XmlAttribute;

public class Director
{
    //Fields :
    private int id;
    private String name;

    //Constructor :
    public Director(int identity,String nameDirector)
    {
        setId(identity);
        setName(nameDirector);
    }

    //Setters :

    @XmlAttribute(name = "idDirector")
    public int getId()
    {
        return id;
    }
    public void setId(int identity)
    {
        id = identity;
    }

    @XmlAttribute(name = "nameDirector")
    public String getName()
    {
        return name;
    }
    public void setName(String nameDirector)
    {
        name = nameDirector;
    }
}
