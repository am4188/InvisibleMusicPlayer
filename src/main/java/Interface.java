import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interface {
    private static boolean appOn = true;
    private static Playlist mainPlaylist;

    public static boolean currentlyPlaying = false;


    public static void main(String[] args) {



        mainPlaylist = new Playlist("Main Library");
        loadPlaylist();

        System.out.println("Hey there, what do you want to do?");
        mainInterface();



    }

    public static void mainInterface() {
        while(appOn) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("A: Play a song"); // Must ask which song to play and then start song with current time
            System.out.println("B: Add a song to your main library");
            System.out.println("C: Delete a song from your main library");
            System.out.println("D: View all songs in your main library");
            System.out.println("E: Go to your playlist section");
            System.out.println("F: Turn off the music player");
            if (currentlyPlaying) {
                System.out.println("G: See what song is currently playing");
            }

            String userChoice = scanner.nextLine();

            if (userChoice.equalsIgnoreCase("A")) {
                System.out.println("What song would you like to listen to? ");
                System.out.println("Answer in this format: <Song> by <Artist>");

                String songByArtist = scanner.nextLine();
                String[] songAndArtistInArray = songByArtist.split(" ");
                String requestedArtist = songAndArtistInArray[0];
                String requestedSong = songAndArtistInArray[1];



            } else if (userChoice.equalsIgnoreCase("B")) {
                System.out.println("What is the title of the song? ");
                String songTitle = scanner.nextLine();
                System.out.println("What is the name of the artist? ");
                String artistName = scanner.nextLine();
                System.out.println("How long is the song? (Use this format: __M__S");; // May separate this into two println's asking for minutes then seconds
                Duration songDuration = Duration.parse("PT" + scanner.nextLine());
                String testing = songTitle;
                Song newSong = new Song(testing, artistName, songDuration);
                mainPlaylist.addSong(newSong);

            } else if (userChoice.equalsIgnoreCase("C")) {
                // Delete a song from the library
                System.out.println("Choose the number of the song to delete from your main playlist ");
                Playlist.printSongsInPlaylist(mainPlaylist);
                int songToDelete = Integer.valueOf(scanner.nextLine()) - 1;
                mainPlaylist.deleteSong(mainPlaylist.playlist.get(songToDelete));

                // mainPlaylist.removeSong(artistToDelete, songTitleToDelete);
            } else if (userChoice.equalsIgnoreCase("D")) {
                printPlaylist();

            } else if (userChoice.equalsIgnoreCase("E")) {
                Playlist.runPlaylistInterface();

            } else if (userChoice.equalsIgnoreCase("F")) {
                System.out.println("******************************************");
                System.out.println("Thank you for using Invisible Music Player");
                System.out.println("******************************************");
                appOn = false;
            } else if (userChoice.equalsIgnoreCase("G")) {
//                if (currentlyPlaying) {
//
//                }
                Playlist.playlistSongPlaying(mainPlaylist);
            }
        }
    }

    public static void printPlaylist() {
        System.out.println("********------------------------------------------********");
        for (Song song : mainPlaylist.playlist) {
            System.out.println(song);
        }
        System.out.println("********------------------------------------------********");
    }

    public static void loadPlaylist() {
        mainPlaylist.addSong(new Song("Welcome Home (Sanitarium)", "Metallica", Duration.parse("PT06M27S")));
        mainPlaylist.addSong(new Song("N.Y. State of Mind", "Nas", Duration.parse("PT4M54S")));
        mainPlaylist.addSong(new Song("Powerslave", "Iron Maiden", Duration.parse("PT13M45S")));
        mainPlaylist.addSong(new Song("Lean On", "Major Lazer & DJ Snake", Duration.parse("PT2M57S")));
        mainPlaylist.addSong(new Song("Scientist", "Twice", Duration.parse("PT3M14S")));
        mainPlaylist.addSong(new Song("Stay Gold", "Run the Jewels", Duration.parse("PT3M27S")));
        mainPlaylist.addSong(new Song("Borderline", "Tame Impala", Duration.parse("PT3M57S")));
        mainPlaylist.addSong(new Song("Time Wind", "M83", Duration.parse("PT4M09S")));
        mainPlaylist.addSong(new Song("Swimming Pools (Drank)", "Kendrick Lamar", Duration.parse("PT4M07S")));
    }



}
