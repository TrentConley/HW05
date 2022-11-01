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
        // Iterating using while loop
        int i = 0;
        while (i < interestingMovies.size()) {
            String m = interestingMovies.get(i);
            if (!this.movies.contains(m)) {
                throw new FilmNotFoundException(m);
            }
            i++;
        }
        // I would have used a for each loop, but order matters.
    }

    /**
     * Watches a movie that is passed in.
     *
     * @param movie Movie to be watched.
     * @throws FilmNotFoundException Will throw if the movie cannot be found.
     */
    public void watchMovie(String movie) throws FilmNotFoundException {
        if (this.watched.contains(movie)) {
            throw new AlreadyWatchedException();
        } else if (!this.movies.contains(movie)) {
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

    /**
     * Main method, code will run from this method.
     *
     * @param args Args that the user enters upon calling the function.
     */
    public static void main(String[] args) {
        String[] arrMovies = {"a", "b", "c", "d", "e"};
        ArrayList<String> movies = createArrayList(arrMovies);

        String[] arrWatched = {"f", "g"};
        ArrayList<String> watched = createArrayList(arrWatched);

        String[] arrRecommended = {"a", "b", "x", "y"};
        ArrayList<String> recommended = createArrayList(arrRecommended);

        MovieTheater m = new MovieTheater(movies, watched);

        String[] arrTestWatchMovie = {"a", "b", "c", "f", "g", "x"}; //should pass for only f and g.
        ArrayList<String> testWatchMovie = createArrayList(arrTestWatchMovie);
        functionTestWatchMovie(m, testWatchMovie);

        String[] arrTestThrowIfMoviesMissing = {"a", "x", "m"};
        ArrayList<String> testThrowIfMoviesMissing = createArrayList(arrTestThrowIfMoviesMissing);
        functionTestThrowIfMoviesMissing(m, testThrowIfMoviesMissing);

        String[] arrTestSelectRecommended = {"a", "b", "f", "x", "m"};
        ArrayList<String> testSelectRecommended = createArrayList(arrTestSelectRecommended);
        functionTestSelectRecommended(m, testSelectRecommended);

        try {
            m.throwIfMoviesMissing(movies);

            m.watchMovie(arrMovies[0]);
            m.watchMovie("z");

            m.selectRecommended(recommended);

            //my tests from here down.
        } catch (FilmNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());

        } catch (AlreadyWatchedException awe) {
            System.out.println(awe.getMessage());
        } finally {
            System.out.println("Took a look at the movies!");
        }
    }

    /**
     * Function to test functionality of watchMovie.
     *
     * @param m movie object that was instantiated earlier.
     * @param a array list to pass into the movie WatchMovies Function.
     */
    private static void functionTestWatchMovie(MovieTheater m, ArrayList<String> a) {
        for (String s : a) {
            try {
                m.watchMovie(s);
            } catch (FilmNotFoundException fnfe) {
                System.out.println(fnfe.getMessage());
            } catch (AlreadyWatchedException awe) {
                System.out.println(awe.getMessage());
            }
        }
    }

    /**
     * Function to test functionality of throwIfMoviesMissing.
     *
     * @param m movie object that was instantiated earlier.
     * @param a array list to pass into the throwIfMoviesMission function.
     */
    private static void functionTestThrowIfMoviesMissing(MovieTheater m, ArrayList<String> a) {
        try {
            m.throwIfMoviesMissing(a);
        } catch (FilmNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (AlreadyWatchedException awe) {
            System.out.println(awe.getMessage());
        }

    }

    private static void functionTestSelectRecommended(MovieTheater m, ArrayList<String> a) {
        try {
            m.throwIfMoviesMissing(a);
        } catch (FilmNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (AlreadyWatchedException awe) {
            System.out.println(awe.getMessage());
        }
    }

    /**
     * Helper method to create Array list of Strings from String[].
     *
     * @param b input String[].
     * @return new Array List of Strings.
     */
    private static ArrayList<String> createArrayList(String[] b) {
        ArrayList<String> a = new ArrayList<String>();
        for (String s : b) {
            a.add(s);
        }
        return a;
    }
}
