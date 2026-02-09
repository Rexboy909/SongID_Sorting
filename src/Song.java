public class Song {
    private final String songId;
    private final String artist;
    private final String genre;
    private final String duration;
    private final int playCount;
    private final String dateAdded;

    public Song(String songId, String artist, String genre, String duration, int playCount, String dateAdded) {
        this.songId = songId;
        this.artist = artist;
        this.genre = genre;
        this.duration = duration;
        this.playCount = playCount;
        this.dateAdded = dateAdded;
    }

    public String getSongId() {
        return songId;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public String getDuration() {
        return duration;
    }

    public int getPlayCount() {
        return playCount;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    @Override
    public String toString() {
        return "Song: " + songId + " | Artist: " + artist + " | Genre: " + genre + 
               " | Duration: " + duration + " | Plays: " + playCount + " | Added: " + dateAdded;
    }
}
