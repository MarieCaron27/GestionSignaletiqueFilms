package Entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;

@XmlRootElement(name = "movie")
public class Movie
{
    //Fields :
    private int id;
    private String title;
    private String originalTitle;
    private String releasedDate;
    private String status;
    private float voteAverage;
    private int voteCount;
    private int runtime;
    private String certification;
    private String posterPath;
    private int budget;
    private String tagline;
    private ArrayList<Genre> genres;
    private ArrayList<Director> directors;
    private ArrayList<Actor> actors;

    //Setters and getters :

    @XmlAttribute(name="id")
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getOriginalTitle() { return originalTitle; }
    public void setOriginalTitle(String originalTitle) { this.originalTitle = originalTitle; }

    public String getReleasedDate() { return releasedDate; }
    public void setReleasedDate(String releasedDate) { this.releasedDate = releasedDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public float getVoteAverage() { return voteAverage; }
    public void setVoteAverage(float voteAverage) { this.voteAverage = voteAverage; }

    public int getVoteCount() { return voteCount; }
    public void setVoteCount(int voteCount) { this.voteCount = voteCount; }

    public int getRuntime() { return runtime; }
    public void setRuntime(int runtime) { this.runtime = runtime; }

    public String getCertification() { return certification; }
    public void setCertification(String certification) { this.certification = certification; }

    public String getPosterPath() { return posterPath; }
    public void setPosterPath(String posterPath) { this.posterPath = posterPath; }

    public int getBudget() { return budget; }
    public void setBudget(int budget) { this.budget = budget; }

    public String getTagline() { return tagline; }
    public void setTagline(String tagline) { this.tagline = tagline; }

    @XmlElementWrapper(name = "genres")
    @XmlElement(name = "genre")
    public ArrayList<Genre> getGenreList() { return genres; }
    public void setGenreList(ArrayList<Genre> genres) { this.genres = genres; }

    @XmlElementWrapper(name = "directors")
    @XmlElement(name = "director")
    public ArrayList<Director> getDirectorList() { return directors; }
    public void setDirectorList(ArrayList<Director> directors) { this.directors = directors; }

    @XmlElementWrapper(name = "actors")
    @XmlElement(name = "actor")
    public ArrayList<Actor> getActorList() { return actors; }
    public void setActorList(ArrayList<Actor> actors) { this.actors = actors; }
}