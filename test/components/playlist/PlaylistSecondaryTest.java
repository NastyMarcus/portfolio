
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

public class PlaylistSecondaryTest {

    private Playlist playlist;
    private Song song1;
    private Song song2;
    private Song song3;

    @BeforeEach
    public void setUp() {
        playlist = new Playlist();
        song1 = new Song("Shape of You", "Ed Sheeran", 240);
        song2 = new Song("Blinding Lights", "The Weeknd", 200);
        song3 = new Song("All of Me", "John Legend", 270);

        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);
    }

    @Test
    public void testSortByTitle() {
        playlist.sortByTitle();
        List<Song> sortedSongs = playlist.getSongs();
        assertEquals("All of Me", sortedSongs.get(0).getTitle());
        assertEquals("Blinding Lights", sortedSongs.get(1).getTitle());
        assertEquals("Shape of You", sortedSongs.get(2).getTitle());
    }

    @Test
    public void testSortByArtist() {
        playlist.sortByArtist();
        List<Song> sortedSongs = playlist.getSongs();
        assertEquals("John Legend", sortedSongs.get(0).getArtist());
        assertEquals("Ed Sheeran", sortedSongs.get(1).getArtist());
        assertEquals("The Weeknd", sortedSongs.get(2).getArtist());
    }

    @Test
    public void testShuffle() {
        playlist.shuffle();
        // Since shuffle is random, we do not assert the exact order, only test that it executes.
        assertEquals(3, playlist.getSongs().size());
    }

    @Test
    public void testLoop() {
        assertDoesNotThrow(() -> playlist.loop(2));
    }
}
