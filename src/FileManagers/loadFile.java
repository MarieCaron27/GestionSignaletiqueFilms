package FileManagers;

import Entities.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class loadFile
{
    public static MovieList loadFile(String filename)
    {
        MovieList movieList = new MovieList();
        ArrayList<Movie> movies = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            String line;

            while ((line = reader.readLine()) != null)
            {
                if (!line.isEmpty())
                {
                    String[] parts = line.split("‣");
                    Movie movie = new Movie();

                    movie.setId(Integer.parseInt(parts[0]));
                    movie.setTitle(!parts[1].isEmpty() ? parts[1] : null);
                    movie.setOriginalTitle(!parts[2].isEmpty() ? parts[2] : null);
                    movie.setReleasedDate(!parts[3].isEmpty() ? parts[3] : null);
                    movie.setStatus(!parts[4].isEmpty() ? parts[4] : null);
                    movie.setVoteAverage(!parts[5].isEmpty() ? Float.parseFloat(parts[5]) : 0);
                    movie.setVoteCount(!parts[6].isEmpty() ? Integer.parseInt(parts[6]) : 0);
                    movie.setRuntime(!parts[7].isEmpty() ? Integer.parseInt(parts[7]) : 0);
                    movie.setCertification(!parts[8].isEmpty() ? parts[8] : null);
                    movie.setPosterPath(!parts[9].isEmpty() ? parts[9] : null);
                    movie.setBudget(!parts[10].isEmpty() ? Integer.parseInt(parts[10]) : 0);
                    movie.setTagline(!parts[11].isEmpty() ? parts[11] : null);

                    movie.setGenreList(parts.length > 12 ? partsToGenre(parts[12]) : new ArrayList<>());
                    movie.setDirectorList(parts.length > 13 ? partsToDirectors(parts[13]) : new ArrayList<>());
                    movie.setActorList(parts.length > 14 ? partsToActors(parts[14]) : new ArrayList<>());

                    movies.add(movie);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        movieList.setMovieList(movies);
        return movieList;
    }


    public static ArrayList<Genre> partsToGenre(String parts)
    {
        ArrayList<Genre> genres = new ArrayList<>();

        if (parts != null && !parts.isEmpty())
        {
            String[] genreParts = parts.split("‖");

            for (String part : genreParts)
            {
                String[] genreInfo = part.split("․");
                genres.add(new Genre(Integer.parseInt(genreInfo[0]), genreInfo[1]));
            }
        }

        return genres;
    }

    public static ArrayList<Director> partsToDirectors(String parts)
    {
        ArrayList<Director> directors = new ArrayList<>();

        if (parts != null && !parts.isEmpty())
        {
            String[] personParts = parts.split("‖");

            for (String part : personParts)
            {
                String[] personInfo = part.split("․");
                directors.add(new Director(Integer.parseInt(personInfo[0]), personInfo[1]));
            }
        }
        return directors;
    }

    public static ArrayList<Actor> partsToActors(String parts) {
        ArrayList<Actor> actors = new ArrayList<>();

        if (parts != null && !parts.isEmpty())
        {
            String[] actorParts = parts.split("‖");

            for (String part : actorParts)
            {
                String[] actorInfo = part.split("․");

                if (actorInfo.length >= 3)
                {
                    actors.add(new Actor(Integer.parseInt(actorInfo[0]), actorInfo[1], actorInfo[2]));
                }
                else
                {
                    actors.add(new Actor(Integer.parseInt(actorInfo[0]), actorInfo[1],null));
                }
            }
        }
        return actors;
    }
}
