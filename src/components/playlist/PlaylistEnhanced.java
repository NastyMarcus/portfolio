/**
 * Enhanced interface that extends PlaylistKernel to include additional
 * operations such as sorting, shuffling, and looping.
 */
public interface PlaylistEnhanced extends PlaylistKernel {

    /**
     * Sorts the playlist by song title in alphabetical order.
     *
     * @ensures the songs are sorted alphabetically by title
     */
    void sortByTitle();

    /**
     * Sorts the playlist by artist name in alphabetical order.
     *
     * @ensures the songs are sorted alphabetically by artist name
     */
    void sortByArtist();

    /**
     * Randomly rearranges the order of songs in the playlist.
     *
     * @ensures the order of the songs in the playlist is randomized
     */
    void shuffle();

    /**
     * Plays the playlist in a loop a specified number of times.
     *
     * @param times
     *            the number of times to loop the playlist
     * @requires times must be greater than or equal to 1
     * @ensures the playlist is played exactly times times in a loop
     */
    void loop(int times);

    /**
     * Returns a string representation of the playlist.
     *
     * @ensures a string representing the playlist is returned, including all
     *          songs and their details
     * @return a string representation of the playlist
     */
    @Override
    String toString();
}
