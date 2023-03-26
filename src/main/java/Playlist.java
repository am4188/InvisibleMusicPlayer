import java.time.Duration;
import java.time.LocalTime;
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

    public void deleteSong(Song song) {
        playlist.remove(song);
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void removeSong(String artistName, String songTitle) {
        for (Song currentSong : this.playlist) {
            if (currentSong.getArtistName().equals(currentSong.getArtistName()) && currentSong.getSongTitle().equals(currentSong.getSongTitle())) {
                this.playlist.remove(currentSong);
            }
        }
    }

    public static void runPlaylistInterface() {

        boolean exitPlaylist = false;
        while (!exitPlaylist) {
            // May move next section to its own static method
            System.out.println("What would you like to do? ");
            System.out.println("A: Listen to a playlist");
            System.out.println("B: Create a new playlist");
            System.out.println("C: Delete a playlist");
            System.out.println("D: View a playlist");
            System.out.println("E: Add a song to your playlist");
            System.out.println("F: Remove a song from your playlist");
            System.out.println("G: Return to main selection page");

            String userChoice = scanner.nextLine();
            if (userChoice.equalsIgnoreCase("A")) {
                System.out.println("Which playlist would you like to listen to? Enter a number");
                printPlaylists();
                int userInput = Integer.valueOf(scanner.nextLine()) - 1;
                Playlist playlistToListenTo = listOfPlaylists.get(userInput);
                printSongsInPlaylist(playlistToListenTo);
                playlistToListenTo.playlistSongPlaying(playlistToListenTo);
//                if (PLAYLSIT != null) {
//                    System.out.println("PLAYLIST is currently playing. Here are the songs in PLAYLIST");
//                    // Print songs in the playlist
//                    MusicPlayer.playlistSongPlaying();
//
//                }

            } else if (userChoice.equalsIgnoreCase("B")) {
                System.out.println("What would you like to call your playlist? ");
                String nameOfNewPlaylist = scanner.nextLine();
                Playlist newPlaylist = new Playlist(nameOfNewPlaylist);

            } else if (userChoice.equalsIgnoreCase("C")) {
                System.out.println("Which playlist would you like to delete? ");
                printPlaylists();
                int playlistToRemove = Integer.valueOf(scanner.nextLine());
                listOfPlaylists.remove(playlistToRemove - 1);

            } else if (userChoice.equalsIgnoreCase("D")) {
                System.out.println("Choose the number of the playlist you would like to view: ");
                printPlaylists();
                int playlistToView = Integer.valueOf(scanner.nextLine());
                printSongsInPlaylist(listOfPlaylists.get(playlistToView - 1));

            } else if (userChoice.equalsIgnoreCase("E")) {
                System.out.println("Which playlist would you like to add songs to? ");
                printPlaylists();

                int playlistToAddSongsTo = Integer.valueOf(scanner.nextLine()) - 1;
                Playlist mainPlaylist = listOfPlaylists.get(0);
                printSongsInPlaylist(mainPlaylist);
                System.out.println("By number, choose a song from your main library to add to this playlist: "); // Create an option to add multiple songs at one time if possible
                Playlist chosenPlaylist = listOfPlaylists.get(playlistToAddSongsTo);
                int songToAdd = Integer.valueOf(scanner.nextLine());

                chosenPlaylist.addSong(mainPlaylist.playlist.get(songToAdd - 1)); // Need to grab the song

            } else if (userChoice.equalsIgnoreCase("F")) {
                System.out.println("Which playlist would you like to remove songs from? ");
                printPlaylists();
                int playlistToRemoveSongsFrom = Integer.valueOf(scanner.nextLine()) - 1;
                printSongsInPlaylist(listOfPlaylists.get(playlistToRemoveSongsFrom - 1));
                System.out.println("By number, choose a song to delete");
                int songToDelete = Integer.valueOf(scanner.nextLine()) - 1;
                Playlist chosenPlaylist = listOfPlaylists.get(playlistToRemoveSongsFrom);
                chosenPlaylist.deleteSong(chosenPlaylist.playlist.get(songToDelete));

            } else if (userChoice.equalsIgnoreCase("G")) {
                System.out.println("Which playlist would you like to see the length of? ");
                printPlaylists();
                int playlistToRemoveSongsFrom = Integer.valueOf(scanner.nextLine()) - 1;
                getPlaylistTimeLength(listOfPlaylists.get(playlistToRemoveSongsFrom - 1));
                //exitPlaylist = true;
            } else {
                exitPlaylist = true;
            }

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

    public static void getPlaylistTimeLength(Playlist playlistName) {
        Duration total = Duration.parse("PT0S");
        for (Song song : playlistName.playlist) {
            total = total.plus(song.getSongLength());
        }
        System.out.println(total);
    }

    public List<Song> getPlaylist() {
        return playlist;
    }

    public static void playlistSongPlaying(Playlist currentPlaylist) {
        LocalTime startTime = LocalTime.now();
        //System.out.println("Enter the time you would like to see which song would be playing: ");
        //LocalTime timeToCheck = LocalTime.parse(scanner.nextLine());
        //System.out.println(startTime.until(timeToCheck, ChronoUnit.MINUTES));
        System.out.println("Enter a time and I will tell you what song will be playing at that time: ");
        LocalTime timeToFindSongAt = LocalTime.parse(scanner.nextLine());

        LocalTime timePlusLengths = startTime;
        for (int i = 0; i < currentPlaylist.playlist.size(); i++) {
            Duration currentSongLength = currentPlaylist.playlist.get(i).getSongLength();
            timePlusLengths = timePlusLengths.plus(currentSongLength);
            if (timePlusLengths.isAfter(timeToFindSongAt)) {
                System.out.println("***********************************************");
                System.out.println("The song playing at " + timeToFindSongAt + " will be:");
                System.out.println(currentPlaylist.playlist.get(i).getSongTitle()+ " by " + currentPlaylist.playlist.get(i).getArtistName());
                System.out.println("***********************************************");
                break; //+ " by " + currentPlaylist.playlist.get(i).getArtistName() + " will be playing at that time.";
            }
        }
    }


}
