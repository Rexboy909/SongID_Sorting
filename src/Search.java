import java.util.ArrayList;

public class Search {

    // Sequential (Linear) Search - O(n)
    public static int sequentialSearch(ArrayList<Song> songs, String targetSongId) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getSongId().equals(targetSongId)) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search - O(log n) - requires sorted array
    public static int binarySearch(ArrayList<Song> songs, String targetSongId) {
        int left = 0, right = songs.size() - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            String midSongId = songs.get(mid).getSongId();
            
            int compare = midSongId.compareTo(targetSongId);
            if (compare == 0) {
                return mid;
            } else if (compare < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


}
