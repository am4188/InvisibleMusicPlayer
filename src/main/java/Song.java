import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Song {
    private String songTitle;
    private String artistName;
    private Duration songLength;
    private Map<String[], Duration> songInformation;

    public Song(String songTitle, String artistName, Duration songLength) {
        this.songTitle = songTitle;
        this.artistName = artistName;
        this.songLength = songLength;

        this.songInformation = new HashMap<>();
        String[] titleAndArtist = new String[] {songTitle, artistName};
        songInformation.put(titleAndArtist, songLength);
    }

    public String getSongTitle() {
        return this.songTitle;
    }

    public String getArtistName() {
        return this.artistName;
    }

    public Duration getSongLength() {
        return this.songLength;
    }

    public String toString() {
        return "Artist: " + this.getArtistName() + " | "  + "Title: " + this.getSongTitle() + " | " + "Length: " + this.getSongLength();
    }




}
