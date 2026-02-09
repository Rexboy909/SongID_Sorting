import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CSVReader {
    public ArrayList<Song> readSongs(String filename, int numLines) {
        ArrayList<Song> songs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine(); // Skip header row
            int count = 0;
            
            while ((line = br.readLine()) != null && count < numLines) {
                String[] fields = line.split(",");
                String songId = fields[0];
                String artist = fields[1];
                String genre = fields[2];
                String duration = fields[3];
                int playCount = Integer.parseInt(fields[4]);
                String dateAdded = fields[5];
                
                Song song = new Song(songId, artist, genre, duration, playCount, dateAdded);
                songs.add(song);
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return songs;
    }
}
