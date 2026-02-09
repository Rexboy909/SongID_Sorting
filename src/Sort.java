import java.util.ArrayList;

public class Sort {

    // Merge Sort - O(n log n)
    public static void mergeSort(ArrayList<Song> songs) {
        if (songs.size() <= 1) {
            return;
        }
        mergeSortHelper(songs, 0, songs.size() - 1);
    }

    private static void mergeSortHelper(ArrayList<Song> songs, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortHelper(songs, left, mid);
            mergeSortHelper(songs, mid + 1, right);
            merge(songs, left, mid, right);
        }
    }

    private static void merge(ArrayList<Song> songs, int left, int mid, int right) {
        ArrayList<Song> temp = new ArrayList<>();
        int i = left, j = mid + 1;

        while (i <= mid && j <= right) {
            if (songs.get(i).getPlayCount() <= songs.get(j).getPlayCount()) {
                temp.add(songs.get(i));
                i++;
            } else {
                temp.add(songs.get(j));
                j++;
            }
        }

        while (i <= mid) {
            temp.add(songs.get(i));
            i++;
        }

        while (j <= right) {
            temp.add(songs.get(j));
            j++;
        }

        for (int k = 0; k < temp.size(); k++) {
            songs.set(left + k, temp.get(k));
        }
    }

    // Quick Sort - O(n log n) average, O(n²) worst
    public static void quickSort(ArrayList<Song> songs) {
        if (songs.size() <= 1) {
            return;
        }
        quickSortHelper(songs, 0, songs.size() - 1);
    }

    private static void quickSortHelper(ArrayList<Song> songs, int left, int right) {
        if (left < right) {
            int pi = partition(songs, left, right);
            quickSortHelper(songs, left, pi - 1);
            quickSortHelper(songs, pi + 1, right);
        }
    }

    private static int partition(ArrayList<Song> songs, int left, int right) {
        int pivot = songs.get(right).getPlayCount();
        int i = left - 1;
        
        for (int j = left; j < right; j++) {
            if (songs.get(j).getPlayCount() < pivot) {
                i++;
                Song temp = songs.get(i);
                songs.set(i, songs.get(j));
                songs.set(j, temp);
            }
        }
        
        Song temp = songs.get(i + 1);
        songs.set(i + 1, songs.get(right));
        songs.set(right, temp);
        return i + 1;
    }

    // Heap Sort - O(n log n)
    public static void heapSort(ArrayList<Song> songs) {
        int n = songs.size();
        
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(songs, n, i);
        }
        
        for (int i = n - 1; i > 0; i--) {
            Song temp = songs.get(0);
            songs.set(0, songs.get(i));
            songs.set(i, temp);
            heapify(songs, i, 0);
        }
    }

    private static void heapify(ArrayList<Song> songs, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left < n && songs.get(left).getPlayCount() > songs.get(largest).getPlayCount()) {
            largest = left;
        }
        
        if (right < n && songs.get(right).getPlayCount() > songs.get(largest).getPlayCount()) {
            largest = right;
        }
        
        if (largest != i) {
            Song temp = songs.get(i);
            songs.set(i, songs.get(largest));
            songs.set(largest, temp);
            heapify(songs, n, largest);
        }
    }

    // ===== SORT BY DATE ADDED =====

    // Merge Sort by Date - O(n log n)
    public static void mergeSortByDate(ArrayList<Song> songs) {
        if (songs.size() <= 1) {
            return;
        }
        mergeSortByDateHelper(songs, 0, songs.size() - 1);
    }

    private static void mergeSortByDateHelper(ArrayList<Song> songs, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortByDateHelper(songs, left, mid);
            mergeSortByDateHelper(songs, mid + 1, right);
            mergeByDate(songs, left, mid, right);
        }
    }

    private static void mergeByDate(ArrayList<Song> songs, int left, int mid, int right) {
        ArrayList<Song> temp = new ArrayList<>();
        int i = left, j = mid + 1;

        while (i <= mid && j <= right) {
            if (songs.get(i).getDateAdded().compareTo(songs.get(j).getDateAdded()) <= 0) {
                temp.add(songs.get(i));
                i++;
            } else {
                temp.add(songs.get(j));
                j++;
            }
        }

        while (i <= mid) {
            temp.add(songs.get(i));
            i++;
        }

        while (j <= right) {
            temp.add(songs.get(j));
            j++;
        }

        for (int k = 0; k < temp.size(); k++) {
            songs.set(left + k, temp.get(k));
        }
    }

    // Quick Sort by Date - O(n log n) average, O(n²) worst
    public static void quickSortByDate(ArrayList<Song> songs) {
        if (songs.size() <= 1) {
            return;
        }
        quickSortByDateHelper(songs, 0, songs.size() - 1);
    }

    private static void quickSortByDateHelper(ArrayList<Song> songs, int left, int right) {
        if (left < right) {
            int pi = partitionByDate(songs, left, right);
            quickSortByDateHelper(songs, left, pi - 1);
            quickSortByDateHelper(songs, pi + 1, right);
        }
    }

    private static int partitionByDate(ArrayList<Song> songs, int left, int right) {
        String pivot = songs.get(right).getDateAdded();
        int i = left - 1;
        
        for (int j = left; j < right; j++) {
            if (songs.get(j).getDateAdded().compareTo(pivot) < 0) {
                i++;
                Song temp = songs.get(i);
                songs.set(i, songs.get(j));
                songs.set(j, temp);
            }
        }
        
        Song temp = songs.get(i + 1);
        songs.set(i + 1, songs.get(right));
        songs.set(right, temp);
        return i + 1;
    }

    // Heap Sort by Date - O(n log n)
    public static void heapSortByDate(ArrayList<Song> songs) {
        int n = songs.size();
        
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyByDate(songs, n, i);
        }
        
        for (int i = n - 1; i > 0; i--) {
            Song temp = songs.get(0);
            songs.set(0, songs.get(i));
            songs.set(i, temp);
            heapifyByDate(songs, i, 0);
        }
    }

    private static void heapifyByDate(ArrayList<Song> songs, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left < n && songs.get(left).getDateAdded().compareTo(songs.get(largest).getDateAdded()) > 0) {
            largest = left;
        }
        
        if (right < n && songs.get(right).getDateAdded().compareTo(songs.get(largest).getDateAdded()) > 0) {
            largest = right;
        }
        
        if (largest != i) {
            Song temp = songs.get(i);
            songs.set(i, songs.get(largest));
            songs.set(largest, temp);
            heapifyByDate(songs, n, largest);
        }
    }
}
