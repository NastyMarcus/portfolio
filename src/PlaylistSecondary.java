import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

public abstract class PlaylistSecondary implements PlaylistEnhanced {

    protected String name;
    protected ArrayList<Song> songs;

    public PlaylistSecondary(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    // Kernel Methods

    @Override
    public void addSong(Song s) {
        this.songs.add(s);
        System.out.println(s.getTitle() + " has been added to the playlist.");
    }

    @Override
    public boolean removeSong(Song s) {
        if (this.containsSong(s)) {
            this.songs.remove(s);
            System.out.println(
                    s.getTitle() + " has been removed from the playlist.");
            return true;
        }
        System.out.println(s.getTitle() + " not found in the playlist.");
        return false;
    }

    @Override
    public boolean containsSong(Song s) {
        return this.songs.contains(s);
    }

    @Override
    public int totalDuration() {
        int totalDurationSeconds = 0;
        for (Song song : this.songs) {
            totalDurationSeconds += song.getDuration();
        }
        return totalDurationSeconds;
    }

    @Override
    public void playAll() {
        for (Song song : this.songs) {
            song.play();
        }
    }

    // Secondary Methods

    @Override
    public void sortByTitle() {
        Collections.sort(this.songs, Comparator.comparing(Song::getTitle));
        System.out.println("Playlist sorted by title.");
    }

    @Override
    public void sortByArtist() {
        Collections.sort(this.songs, Comparator.comparing(Song::getArtist));
        System.out.println("Playlist sorted by artist.");
    }

    @Override
    public void shuffle() {
        Collections.shuffle(this.songs, new Random());
        System.out.println("Playlist shuffled.");
    }

    @Override
    public void loop(int times) {
        if (times < 1) {
            throw new IllegalArgumentException(
                    "Times must be greater than or equal to 1");
        }
        System.out.println("Playing playlist in a loop " + times + " times:");
        for (int i = 0; i < times; i++) {
            System.out.println("Loop " + (i + 1) + ":");
            this.playAll();
        }
    }

    @Override
    public String toString() {
        StringBuilder playlistDetails = new StringBuilder(
                "Playlist: " + this.name + "\n");
        for (Song song : this.songs) {
            playlistDetails.append(song).append("\n");
        }
        return playlistDetails.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PlaylistSecondary)) {
            return false;
        }
        PlaylistSecondary other = (PlaylistSecondary) o;
        return this.songs.equals(other.songs) && this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.songs);
    }
}
