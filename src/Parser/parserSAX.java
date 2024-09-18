package Parser;

import java.io.File; import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
public class parserSAX
{
    public void parse(String filePath, handlerForSAX handler) throws ParserConfigurationException, SAXException, IOException
    {
        try
        {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setValidating(false);
            factory.setNamespaceAware(true);
            SAXParser sp = factory.newSAXParser();
            sp.getXMLReader().setContentHandler(handler);
            sp.getXMLReader().parse(new File(filePath).toURI().toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        }
        catch (SAXException e)
        {
            e.printStackTrace();
        }

    }
}
