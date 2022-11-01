/**
 * Unchecked exception class to handle if a movie has already been watched.
 *
 * @author Trent Conley
 * @version 1
 */
public class AlreadyWatchedException extends RuntimeException {

    /**
     * 0 arg constructor, calls super with message as described in solution.
     */
    public AlreadyWatchedException() {
        super("You’ve already seen this movie here!");
    }
}
