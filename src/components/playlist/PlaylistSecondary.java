import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public abstract class PlaylistSecondary implements PlaylistEnhanced {

    @Override
    public void sortByTitle() {
        Collections.sort(this.getSongs(), Comparator.comparing(Song::getTitle));
    }

    @Override
    public void sortByArtist() {
        Collections.sort(this.getSongs(),
                Comparator.comparing(Song::getArtist));
    }

    @Override
    public void shuffle() {
        Collections.shuffle(this.getSongs(), new Random());
    }

    @Override
    public void loop(int times) {
        if (times < 1) {
            throw new IllegalArgumentException("Times must be >= 1");
        }
        for (int i = 0; i < times; i++) {
            this.playAll();
        }
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder("Playlist Details:\n");
        for (Song song : this.getSongs()) {
            details.append(song).append("\n");
        }
        return details.toString();
    }

    /**
     * Abstract method to get the list of songs in the playlist. This method
     * will be implemented in the concrete Playlist class.
     *
     * @return the list of songs in the playlist
     */
    protected abstract java.util.List<Song> getSongs();
}
