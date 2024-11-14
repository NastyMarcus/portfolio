import components.playlist.Playlist;

public class PlaylistDemo2 {

    public static void main(String[] args) {
        Playlist myPlaylist = new Playlist();

        // Create songs
        Song song1 = new Song("Song C", "Artist A", 220);
        Song song2 = new Song("Song B", "Artist B", 180);
        Song song3 = new Song("Song A", "Artist C", 210);

        // Add songs to the playlist
        myPlaylist.addSong(song1);
        myPlaylist.addSong(song2);
        myPlaylist.addSong(song3);

        // Sort by title
        myPlaylist.sortByTitle();
        System.out.println("Playlist sorted by title:\n" + myPlaylist);

        // Sort by artist
        myPlaylist.sortByArtist();
        System.out.println("Playlist sorted by artist:\n" + myPlaylist);

        // Shuffle playlist
        myPlaylist.shuffle();
        System.out.println("Playlist after shuffle:\n" + myPlaylist);

        // Loop playlist twice
        System.out.println("Looping playlist 2 times:");
        myPlaylist.loop(2);
    }
}
