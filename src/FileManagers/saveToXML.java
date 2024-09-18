package FileManagers;

import Entities.MovieList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

public class saveToXML
{
    public static void saveToXML(MovieList ml) throws JAXBException, IOException
    {
        JAXBContext context = JAXBContext.newInstance(MovieList.class);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n".getBytes());
        baos.write("<!DOCTYPE MovieList SYSTEM \"movies.dtd\">".getBytes());

        marshaller.marshal(ml, baos);

        // Convert the marshalled content to a string
        String xmlContent = baos.toString();

        // Insert the xsi:noNamespaceSchemaLocation and xmlns:xsi attributes
        xmlContent = xmlContent.replaceFirst(
                "<MovieList>",
                "<MovieList xsi:noNamespaceSchemaLocation=\"movies.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
        );

        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\Utilisateur\\Desktop\\Files\\movies.xml"))
        {
            fos.write(xmlContent.getBytes());
            fos.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void createDTD(String filename) throws IOException
    {
        String dtdContent = "<!ELEMENT movieList (movies)>\n" +
                            "<!ATTLIST movieList\n" +
                                    "xsi:noNamespaceSchemaLocation CDATA #IMPLIED\n" +
                                    "xmlns:xsi CDATA #FIXED \"http://www.w3.org/2001/XMLSchema-instance\">\n" +

                            "<!ELEMENT movies (movie*)>\n" +
                            "<!ELEMENT movie (title, originalTitle, releasedDate?, status?, voteAverage?, voteCount?, runtime?, certification?, posterPath?, budget?, tagline?, genres?, directors?, actors?)>\n" +
                            "<!ATTLIST movie id CDATA #REQUIRED>\n" +
                            "<!ELEMENT title (#PCDATA)>\n" +
                            "<!ELEMENT originalTitle (#PCDATA)>\n" +
                            "<!ELEMENT releasedDate (#PCDATA)>\n" +
                            "<!ELEMENT status (#PCDATA)>\n" +
                            "<!ELEMENT voteAverage (#PCDATA)>\n" +
                            "<!ELEMENT voteCount (#PCDATA)>\n" +
                            "<!ELEMENT runtime (#PCDATA)>\n" +
                            "<!ELEMENT certification (#PCDATA)>\n" +
                            "<!ELEMENT posterPath (#PCDATA)>\n" +
                            "<!ELEMENT budget (#PCDATA)>\n" +
                            "<!ELEMENT tagline (#PCDATA)>\n" +
                            "<!ELEMENT genres (genre*)>\n" +
                            "<!ELEMENT genre (name)>\n" +
                            "<!ATTLIST genre idGenre CDATA #REQUIRED>\n" +
                            "<!ATTLIST genre nameGenre CDATA #IMPLIED>\n" +
                            "<!ELEMENT directors (director*)>\n" +
                            "<!ELEMENT director EMPTY>\n" +
                            "<!ATTLIST director idDirector CDATA #REQUIRED>\n" +
                            "<!ATTLIST director nameDirector CDATA #REQUIRED>\n" +
                            "<!ELEMENT actors (actor*)>\n" +
                            "<!ELEMENT actor (character?)>\n" +
                            "<!ATTLIST actor idActor CDATA #REQUIRED>\n" +
                            "<!ATTLIST actor nameActor CDATA #REQUIRED>\n" +
                            "<!ATTLIST actor characterActor CDATA #IMPLIED>\n" +
                            "<!ELEMENT name (#PCDATA)>\n" +
                            "<!ELEMENT character (#PCDATA)>";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename)))
        {
            writer.write(dtdContent);
            System.out.println("DTD crée sans souci !");
        }
    }
}
