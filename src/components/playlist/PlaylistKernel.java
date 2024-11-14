/**
 * Kernel interface representing the basic operations of a playlist.
 */
public interface PlaylistKernel extends Standard<Playlist> {

    /**
     * Adds a song to the playlist.
     *
     * @param s
     *            the song to add
     * @ensures the song s is added to the playlist
     */
    void addSong(Song s);

    /**
     * Removes a song from the playlist.
     *
     * @param s
     *            the song to remove
     * @requires the song s must exist in the playlist
     * @ensures the song s is removed from the playlist if it exists
     * @return true if the song was successfully removed, false otherwise
     */
    boolean removeSong(Song s);

    /**
     * Checks if the song is in the playlist.
     *
     * @param s
     *            the song to check
     * @ensures true is returned if the song s is in the playlist, false
     *          otherwise
     * @return true if the playlist contains the song, false otherwise
     */
    boolean containsSong(Song s);

    /**
     * Returns the total duration of all songs in the playlist in seconds.
     *
     * @ensures the total duration is the sum of the durations of all songs in
     *          the playlist
     * @return the total duration of the playlist in seconds
     */
    int totalDuration();

    /**
     * Plays all songs in the playlist.
     *
     * @ensures all songs in the playlist are played in the order they were
     *          added
     */
    void playAll();
}
