
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class PlaylistKernelTest {

    private Playlist playlist;
    private Song song1;
    private Song song2;

    @BeforeEach
    public void setUp() {
        playlist = new Playlist();
        song1 = new Song("Shape of You", "Ed Sheeran", 240);
        song2 = new Song("Blinding Lights", "The Weeknd", 200);
    }

    @Test
    public void testAddSong() {
        playlist.addSong(song1);
        assertTrue(playlist.containsSong(song1));
    }

    @Test
    public void testRemoveSong() {
        playlist.addSong(song1);
        assertTrue(playlist.removeSong(song1));
        assertFalse(playlist.containsSong(song1));
    }

    @Test
    public void testContainsSong() {
        playlist.addSong(song1);
        assertTrue(playlist.containsSong(song1));
        assertFalse(playlist.containsSong(song2));
    }

    @Test
    public void testTotalDuration() {
        playlist.addSong(song1);
        playlist.addSong(song2);
        assertEquals(440, playlist.totalDuration());
    }

    @Test
    public void testPlayAll() {
        playlist.addSong(song1);
        playlist.addSong(song2);
        // Test ensures playAll runs without exceptions.
        assertDoesNotThrow(() -> playlist.playAll());
    }
}
