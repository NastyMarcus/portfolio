// A class representing a Song
class Song {
    private String title;
    private String artist;
    private int duration; // in seconds

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

// A class representing a Playlist
public class Playlist extends PlaylistSecondary {

    public Playlist(String name) {
        super(name);
    }

}
