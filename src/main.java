import java.io.BufferedReader;
import java.io.FileReader;

public class main {
    public static void main(String[] args) {
        readSongs("src/data/songs10k.csv", 2000);  // Print first 5 lines
    }
    
    public static void readSongs(String filename, int numLines) {
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
                
                System.out.println("Song: " + songId + " | Artist: " + artist + " | Genre: " + genre + 
                                   " | Duration: " + duration + " | Plays: " + playCount + " | Added: " + dateAdded);
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}