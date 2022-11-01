/**
 * Check exception class to handle if a movie does not exit.
 *
 * @author Trent Conley
 * @version 1
 */
class FilmNotFoundException extends Exception {

    /**
     * 1 arg constuctor, message is that the movie is not found.
     * @param movie that is not found.
     */
    FilmNotFoundException(String movie) {
        super(movie + " is not playing at this movie theater.");
    }
}