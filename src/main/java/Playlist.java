import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Playlist {
    List<Song> playlist;
    private String playlistName;
    public static List<Playlist> listOfPlaylists = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public Playlist(String playlistName) {
        this.playlist = new ArrayList<>();
        this.playlistName = playlistName;
        listOfPlaylists.add(this);
    }

    public void addSong(Song song) {
        playlist.add(song);
    }

    public void removeSong(String artistName, String songTitle) {
        for (Song currentSong : this.playlist) {
            if (currentSong.getArtistName().equals(currentSong.getArtistName()) && currentSong.getSongTitle().equals(currentSong.getSongTitle())) {
                this.playlist.remove(currentSong);
            }
        }
    }

    public static void runPlaylistInterface() {
        System.out.println("What would you like to do? ");
        System.out.println("A: Listen to a playlist");
        System.out.println("B: Create a new playlist");
        System.out.println("C: Delete a playlist");
        System.out.println("D: View a playlist");
        System.out.println("E: Return to the main menu");

        String userChoice = scanner.nextLine();

        if (userChoice.equalsIgnoreCase("A")) {
            System.out.println("Which playlist would you like to view? ");
            // Display names of all current playlists. The main playlist should still display even if user has not created any playlists
            String playlistToView = scanner.nextLine();
            // Make sure
            // Display all the songs in that playlist, plus a number for each song so users can easily choose them
        } else if (userChoice.equalsIgnoreCase("B")) {
            System.out.println("What would you like to call your playlist? ");
            String nameOfNewPlaylist = scanner.nextLine();
            Playlist newPlaylist = new Playlist(nameOfNewPlaylist);


        } else if (userChoice.equalsIgnoreCase("C")) {

        } else if (userChoice.equalsIgnoreCase("D")) {
            System.out.println("Choose the number of the playlist you would like to view: ");
            printPlaylists();
            int playlistToView = Integer.valueOf(scanner.nextLine());
            printSongsInPlaylist(listOfPlaylists.get(playlistToView - 1));
        } else if (userChoice.equalsIgnoreCase("E")) {
            System.out.println("Which playlist would you like to add songs to? ");
            printPlaylists();
            int playlistToAddSongsTo = Integer.valueOf(scanner.nextLine());
            printSongsInPlaylist(listOfPlaylists.get(0));
            System.out.println("By number, choose a song from your main library to add to this playlist: "); // Create an option to add multiple songs at one time if possible
            Playlist chosenPlaylist = listOfPlaylists.get(playlistToAddSongsTo - 1);
            Playlist mainPlaylist = listOfPlaylists.get(0);
            int songToAdd = Integer.valueOf(scanner.nextLine());

            chosenPlaylist.addSong(mainPlaylist.playlist.get(songToAdd - 1)); // Need to grab the song
            //Song chosenSong = listOfPlaylists.get(playlistToAddSongsTo - 1).playlist.get(1);

        }

    }

    public static void printPlaylists() {
        int counter = 1;
        System.out.println("----------------------------------------------------");
        for (Playlist currentPlaylist : listOfPlaylists) {
            System.out.println(counter + ". " + currentPlaylist.playlistName);
            counter++;
        }
        System.out.println("----------------------------------------------------");
    }

    public static void printSongsInPlaylist(Playlist playlistName) {
        int counter = 1;
        System.out.println("----------------------------------------------------");
        for (Song song : playlistName.playlist) {
            System.out.println(counter + ". " + song);
            counter++;
        }
        System.out.println("----------------------------------------------------");
    }


}
