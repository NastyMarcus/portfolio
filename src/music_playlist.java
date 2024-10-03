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
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    public void play() {
        System.out.println("Playing: " + title + " by " + artist);
    }

    @Override
    public String toString() {
        return title + " by " + artist + " (" + duration + " seconds)";
    }
}

// A class representing a Playlist
class Playlist {
    private String name;
    private ArrayList<Song> songs;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    // Kernel Methods

    // Adds a song to the playlist
    public void addSong(Song s) {
        songs.add(s);
        System.out.println(s.getTitle() + " has been added to the playlist.");
    }

    // Removes a song from the playlist
    public void removeSong(Song s) {
        if (songs.remove(s)) {
            System.out.println(s.getTitle() + " has been removed from the playlist.");
        } else {
            System.out.println(s.getTitle() + " not found in the playlist.");
        }
    }

    // Checks if the song is in the playlist
    public boolean containsSong(Song s) {
        return songs.contains(s);
    }

    // Returns the total duration of the playlist in seconds
    public int totalDuration() {
        int totalDurationSeconds = 0;
        for (Song song : songs) {
            totalDurationSeconds += song.getDuration();
        }
        return totalDurationSeconds;
    }

    // Secondary Methods

    // Sorts the playlist by song title in alphabetical order
    public void sortByTitle() {
        Collections.sort(songs, Comparator.comparing(Song::getTitle));
        System.out.println("Playlist sorted by title.");
    }

    // Sorts the playlist by artist name
    public void sortByArtist() {
        Collections.sort(songs, Comparator.comparing(Song::getArtist));
        System.out.println("Playlist sorted by artist.");
    }

    // Randomly rearranges the order of songs in the playlist
    public void shuffle() {
        Collections.shuffle(songs, new Random());
        System.out.println("Playlist shuffled.");
    }

    // Plays the playlist in a loop for a specified number of times
    public void loop(int times) {
        System.out.println("Playing playlist in a loop " + times + " times:");
        for (int i = 0; i < times; i++) {
            System.out.println("Loop " + (i + 1) + ":");
            playAll();
        }
    }

    // Plays all songs in the playlist
    public void playAll() {
        for (Song song : songs) {
            song.play();
        }
    }

    @Override
    public String toString() {
        StringBuilder playlistDetails = new StringBuilder("Playlist: " + name + "\n");
        for (Song song : songs) {
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
        System.out.println("Contains 'Shape of You': " + myPlaylist.containsSong(song1));
        System.out.println("Total duration: " + myPlaylist.totalDuration() + " minutes");

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
