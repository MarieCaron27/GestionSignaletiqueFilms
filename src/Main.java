import Entities.MovieList;
import Parser.handlerForSAX;
import Parser.parserSAX;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

import static FileManagers.loadFile.loadFile;
import static FileManagers.saveToXML.createDTD;
import static FileManagers.saveToXML.saveToXML;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            MovieList ml = loadFile("C:\\Users\\Utilisateur\\Desktop\\Files\\1000movies.txt");

            saveToXML(ml);

            createDTD("C:\\Users\\Utilisateur\\Desktop\\Files\\movies.dtd");

            System.out.println("La liste des films a été sauvegardée avec succès dans un fichier XML !");

            parserSAX sp = new parserSAX();

            try
            {
                sp.parse("C:\\Users\\Utilisateur\\Desktop\\Files\\movies.xml", new handlerForSAX());
            }
            catch (ParserConfigurationException | IOException | org.xml.sax.SAXException e)
            {
                e.printStackTrace();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
}
