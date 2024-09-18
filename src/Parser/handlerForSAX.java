package Parser;

import Entities.Movie;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class handlerForSAX extends DefaultHandler
{
    private int pg13Count = 0;
    private List<Movie> movies = new ArrayList<>();
    private Movie currentMovie;
    private StringBuilder currentValue = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        currentValue.setLength(0); // Clear the current value

        if (qName.equalsIgnoreCase("movie"))
        {
            currentMovie = new Movie();
            currentMovie.setId(Integer.parseInt(attributes.getValue("id")));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
        currentValue.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        if (currentMovie == null)
        {
            return;
        }

        switch (qName.toLowerCase())
        {
            case "title":
                currentMovie.setTitle(currentValue.toString());
                break;

            case "certification":
                currentMovie.setCertification(currentValue.toString());
                if ("PG-13".equalsIgnoreCase(currentMovie.getCertification()))
                {
                    pg13Count++;
                }
                break;

            case "voteaverage":
                currentMovie.setVoteAverage(Float.parseFloat(currentValue.toString()));
                break;

            case "movie":
                movies.add(currentMovie);
                currentMovie = null; // Clear currentMovie after adding
                break;

            default:
                break;
        }
    }

    @Override
    public void endDocument() throws SAXException
    {
        // Sort movies by vote average in descending order
        Collections.sort(movies, Comparator.comparingDouble(Movie::getVoteAverage).reversed());

        System.out.println("Number of PG-13 movies: " + pg13Count);

        System.out.println("Top 10 movies by vote average:");
        for (int i = 0; i < Math.min(10, movies.size()); i++)
        {
            Movie movie = movies.get(i);
            System.out.println((i + 1) + ". " + movie.getTitle() + " - Vote Average: " + movie.getVoteAverage());
        }
    }
}
