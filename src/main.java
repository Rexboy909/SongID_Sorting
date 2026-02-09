import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        CSVReader reader = new CSVReader();
        ArrayList<Song> songs = reader.readSongs("data/songs10k.csv", 2);
        
        for (Song song : songs) {
            System.out.println(song);
        }
    }
}