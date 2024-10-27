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