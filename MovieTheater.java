import java.util.ArrayList;
/**
 * This class represents a movie theater playing different movies.
 *
 * @author Trent Conley
 * @version 1
 */
public class MovieTheater {
    private ArrayList<String> movies;
    private ArrayList<String> watched;

    /**
     * 2 arg constructor, takes in both movies and watched array lists.
     *
     * @param movies the movies shown at the theater.
     * @param watched the movies you have already watched at the theater.
     */
    MovieTheater(ArrayList<String> movies, ArrayList<String> watched) {
        this.movies = new ArrayList<>(movies);
        this.watched = new ArrayList<>(watched);
    }

    public void throwIfMoviesMissing(ArrayList<String> interestingMovies) throws FilmNotFoundException {
        
    }
}
