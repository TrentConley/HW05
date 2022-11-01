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

    /**
     * throws Exception if there movies passed in are either already watched or not shown in theater.
     *
     * @param interestingMovies array list of movies.
     * @throws FilmNotFoundException if the interesting movies are not in this.movies.
     */
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

    /**
     * Makes and returns a list of movies to see based off of friend recomendation. 
     * @param recommendedMovies Movies that the friend recomended
     * @return movies that I will see, an array list.
     */
    public ArrayList<String> selectRecommended(ArrayList<String> recommendedMovies) {
        ArrayList<String> willSee = new ArrayList<String>();
        for (String movie : recommendedMovies) {
            if (this.movies.contains(movie)) {
                willSee.add(movie);
            }
        }
        return willSee;
    }

    public static void main(String[] args) {
        String[] arrMovies = {"a", "b", "c", "d", "e"};
        ArrayList<String> movies = createArrayList(arrMovies);
        
        String[] arrWatched = {"f", "g"};
        ArrayList<String> watched = createArrayList(arrWatched);

        String[] arrRecommended = {"a", "b", "x", "y"};
        ArrayList<String> recommended = createArrayList(arrRecommended);

        MovieTheater m = new MovieTheater(movies, watched);
        
        

        try {
            m.throwIfMoviesMissing(movies);

            m.watchMovie(arrMovies[0]);
            m.watchMovie("z");
        } catch (FilmNotFoundException fnfe) {

        }
    }

    private static ArrayList<String> createArrayList(String[] b) {
        ArrayList<String> a = new ArrayList<String>();
        for (String s : b) {
            a.add(s);
        }
        return a;
    }
}
