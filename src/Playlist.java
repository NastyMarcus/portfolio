import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

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
public class Playlist implements PlaylistEnhanced {
    private String name;
    private ArrayList<Song> songs;

    public Playlist(String name) {
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
        if (this.songs.remove(s)) {
            System.out.println(
                    s.getTitle() + " has been removed from the playlist.");
            return true;
        } else {
            System.out.println(s.getTitle() + " not found in the playlist.");
            return false;
        }
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
}

// Main class demonstrating the Playlist
public class Main {
    public static void main(String[] args) {
        // Creating a new playlist
        Playlist myPlaylist = new Playlist("My Favorite Songs");

        // Creating some songs
        Song song1 = new Song("Shape of You", "Ed Sheeran", 240);
        Song song2 = new Song("Blinding Lights", "The Weeknd", 200);
        Song song3 = new Song("Fly", "Matt Lv", 220);
        Song song4 = new Song("LOVE.", "Kendrick Lamar", 180);

        // Adding songs to the playlist
        myPlaylist.addSong(song1);
        myPlaylist.addSong(song2);
        myPlaylist.addSong(song3);
        myPlaylist.addSong(song4);

        // Displaying playlist details
        System.out.println(myPlaylist);

        // Demonstrating kernel methods
        System.out.println(
                "Contains 'Shape of You': " + myPlaylist.containsSong(song1));
        System.out.println(
                "Total duration: " + myPlaylist.totalDuration() + " minutes");

        // Demonstrating secondary methods
        myPlaylist.sortByTitle();
        System.out.println(myPlaylist);

        myPlaylist.sortByArtist();
        System.out.println(myPlaylist);

        myPlaylist.shuffle();
        System.out.println(myPlaylist);

        // Playing the playlist in a loop
        myPlaylist.loop(2);
    }
}
