import java.util.ArrayList;
import java.util.List;

// A class representing a Song
class Song {
    private String title;
    private String artist;
    private int duration;

    public Song(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getTitle() {
        return this.title;
    }

    public String getArtist() {
        return this.artist;
    }

    public int getDuration() {
        return this.duration;
    }

    public void play() {
        System.out.println("Playing: " + this.title + " by " + this.artist);
    }

    @Override
    public String toString() {
        return this.title + " by " + this.artist + " (" + this.duration
                + " seconds)";
    }
}

// Concrete implementation of the Playlist class
public class Playlist extends PlaylistSecondary {

    private List<Song> songs;

    public Playlist() {
        this.songs = new ArrayList<>();
    }

    @Override
    public void addSong(Song s) {
        this.songs.add(s);
    }

    @Override
    public boolean removeSong(Song s) {
        return this.songs.remove(s);
    }

    @Override
    public boolean containsSong(Song s) {
        return this.songs.contains(s);
    }

    @Override
    public int totalDuration() {
        return this.songs.stream().mapToInt(Song::getDuration).sum();
    }

    @Override
    public void playAll() {
        for (Song song : this.songs) {
            song.play();
        }
    }

    @Override
    protected List<Song> getSongs() {
        return this.songs;
    }
}
