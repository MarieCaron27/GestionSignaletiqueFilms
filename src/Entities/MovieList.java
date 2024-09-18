package Entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "movieList")
public class MovieList
{
    //Field :
    ArrayList<Movie> movies;

    //Constructor :
    public MovieList()
    {

    }

    //Setter + getter :
    public void setMovieList(ArrayList<Movie> movies)
    {
        this.movies = movies;
    }

    @XmlElementWrapper(name = "movies")
    @XmlElement(name = "movie")
    public ArrayList<Movie> getMovieList()
    {
        return movies;
    }
}
