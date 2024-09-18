package Entities;

import javax.xml.bind.annotation.XmlAttribute;

public class Actor
{
    //Fields :
    private int id;
    private String name;
    private String character;

    //Constructor :
    public Actor(int identity,String nameActor,String characterActor)
    {
        setId(identity);
        setName(nameActor);
        setCharacter(characterActor);
    }

    //Setters + getters :
    @XmlAttribute(name = "idActor")
    public int getId()
    {
        return id;
    }
    public void setId(int identity)
    {
        id = identity;
    }

    @XmlAttribute(name = "nameActor")
    public String getName()
    {
        return name;
    }
    public void setName(String nameActor)
    {
        name = nameActor;
    }

    @XmlAttribute(name = "characterActor")
    public String getCharacter()
    {
        return character;
    }
    public void setCharacter(String characterActor)
    {
        character = characterActor;
    }
}
