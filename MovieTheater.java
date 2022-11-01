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
        // Iterating ArrayList using Iterator
        for (String m : interestingMovies) {
            if (! this.movies.contains(m)) {
                throw new FilmNotFoundException(m);
            }
        }
    }

    public void watchMovie(String movie) throws FilmNotFoundException {
        if (this.watched.contains(movie)) {
            throw new AlreadyWatchedException();
        } else if (! this.movies.contains(movie)) {
            throw new FilmNotFoundException(movie);
        } else {
            this.movies.remove(movie);
            this.watched.add(movie);
        }
    }

    public ArrayList<String> selectRecommended(ArrayList<String> recommendedMovies) {
        return null;
    }
}
