import java.util.ArrayList;

public class Search {

    // Sequential (Linear) Search - O(n)
    public static int sequentialSearch(ArrayList<Song> songs, int targetPlayCount) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getPlayCount() == targetPlayCount) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search - O(log n) - requires sorted array
    public static int binarySearch(ArrayList<Song> songs, int targetPlayCount) {
        int left = 0, right = songs.size() - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midPlayCount = songs.get(mid).getPlayCount();
            
            if (midPlayCount == targetPlayCount) {
                return mid;
            } else if (midPlayCount < targetPlayCount) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Selection Search
    public static int selectionSearch(ArrayList<Song> songs, int targetPlayCount) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getPlayCount() == targetPlayCount) {
                return i;
            }
        }
        return -1;
    }

    // Insertion Search
    public static int insertionSearch(ArrayList<Song> songs, int targetPlayCount) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getPlayCount() == targetPlayCount) {
                return i;
            }
        }
        return -1;
    }

    // Bubble Search
    public static int bubbleSearch(ArrayList<Song> songs, int targetPlayCount) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getPlayCount() == targetPlayCount) {
                return i;
            }
        }
        return -1;
    }
}
