import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        CSVReader reader = new CSVReader();
        ArrayList<Song> songs = reader.readSongs("data/songs10k.csv", 2000);
        
        // Test algorithms and collect results
        ArrayList<String> results = new ArrayList<>();
        results.add("Algorithm,Time (nanoseconds),Time (milliseconds)");
        
        System.out.println("=== SEARCH ALGORITHMS ===");
        
        // Sequential Search
        ArrayList<Song> songsForSequential = new ArrayList<>(songs);
        long seqTime = Timer.timeSearch(() -> {
            Search.sequentialSearch(songsForSequential, 5000);
        });
        results.add("Sequential Search," + seqTime + "," + (seqTime / 1_000_000.0));
        System.out.println("Sequential Search: " + seqTime + " ns (" + (seqTime / 1_000_000.0) + " ms)");
        
        // Binary Search (on sorted data)
        ArrayList<Song> songsForBinary = new ArrayList<>(songs);
        Sort.mergeSort(songsForBinary);
        long binTime = Timer.timeSearch(() -> {
            Search.binarySearch(songsForBinary, 5000);
        });
        results.add("Binary Search," + binTime + "," + (binTime / 1_000_000.0));
        System.out.println("Binary Search: " + binTime + " ns (" + (binTime / 1_000_000.0) + " ms)");
        
        // Selection
        ArrayList<Song> songsForSelection = new ArrayList<>(songs);
        long selectionTime = Timer.timeSearch(() -> {
            Search.selectionSearch(songsForSelection, 5000);
        });
        results.add("Selection (Search)," + selectionTime + "," + (selectionTime / 1_000_000.0));
        System.out.println("Selection (Search): " + selectionTime + " ns (" + (selectionTime / 1_000_000.0) + " ms)");
        
        // Insertion
        ArrayList<Song> songsForInsertion = new ArrayList<>(songs);
        long insertionTime = Timer.timeSearch(() -> {
            Search.insertionSearch(songsForInsertion, 5000);
        });
        results.add("Insertion (Search)," + insertionTime + "," + (insertionTime / 1_000_000.0));
        System.out.println("Insertion (Search): " + insertionTime + " ns (" + (insertionTime / 1_000_000.0) + " ms)");
        
        // Bubble
        ArrayList<Song> songsForBubble = new ArrayList<>(songs);
        long bubbleTime = Timer.timeSearch(() -> {
            Search.bubbleSearch(songsForBubble, 5000);
        });
        results.add("Bubble (Search)," + bubbleTime + "," + (bubbleTime / 1_000_000.0));
        System.out.println("Bubble (Search): " + bubbleTime + " ns (" + (bubbleTime / 1_000_000.0) + " ms)");
        
        System.out.println("\n=== SORTING ALGORITHMS ===");
        
        // Merge Sort
        ArrayList<Song> songsForMerge = new ArrayList<>(songs);
        long mergeTime = Timer.timeSort(() -> {
            Sort.mergeSort(songsForMerge);
        });
        results.add("Merge (By Playcount)," + mergeTime + "," + (mergeTime / 1_000_000.0));
        System.out.println("Merge (By Playcount): " + mergeTime + " ns (" + (mergeTime / 1_000_000.0) + " ms)");
        
        // Quick Sort
        ArrayList<Song> songsForQuick = new ArrayList<>(songs);
        long quickTime = Timer.timeSort(() -> {
            Sort.quickSort(songsForQuick);
        });
        results.add("Quick (By Playcount)," + quickTime + "," + (quickTime / 1_000_000.0));
        System.out.println("Quick (By Playcount): " + quickTime + " ns (" + (quickTime / 1_000_000.0) + " ms)");
        
        // Heap Sort
        ArrayList<Song> songsForHeap = new ArrayList<>(songs);
        long heapTime = Timer.timeSort(() -> {
            Sort.heapSort(songsForHeap);
        });
        results.add("Heap (By Playcount)," + heapTime + "," + (heapTime / 1_000_000.0));
        System.out.println("Heap (By Playcount): " + heapTime + " ns (" + (heapTime / 1_000_000.0) + " ms)");
        
        System.out.println("\n=== SORTING ALGORITHMS (By Date Added) ===");
        
        // Merge Sort by Date
        ArrayList<Song> songsForMergeDate = new ArrayList<>(songs);
        long mergeDateTime = Timer.timeSort(() -> {
            Sort.mergeSortByDate(songsForMergeDate);
        });
        results.add("Merge (By Date)," + mergeDateTime + "," + (mergeDateTime / 1_000_000.0));
        System.out.println("Merge (By Date): " + mergeDateTime + " ns (" + (mergeDateTime / 1_000_000.0) + " ms)");
        
        // Quick Sort by Date
        ArrayList<Song> songsForQuickDate = new ArrayList<>(songs);
        long quickDateTime = Timer.timeSort(() -> {
            Sort.quickSortByDate(songsForQuickDate);
        });
        results.add("Quick (By Date)," + quickDateTime + "," + (quickDateTime / 1_000_000.0));
        System.out.println("Quick (By Date): " + quickDateTime + " ns (" + (quickDateTime / 1_000_000.0) + " ms)");
        
        // Heap Sort by Date
        ArrayList<Song> songsForHeapDate = new ArrayList<>(songs);
        long heapDateTime = Timer.timeSort(() -> {
            Sort.heapSortByDate(songsForHeapDate);
        });
        results.add("Heap (By Date)," + heapDateTime + "," + (heapDateTime / 1_000_000.0));
        System.out.println("Heap (By Date): " + heapDateTime + " ns (" + (heapDateTime / 1_000_000.0) + " ms)");
        
        // Write results to CSV
        writeResultsToCSV(results);
    }
    
    private static void writeResultsToCSV(ArrayList<String> results) {
        try (FileWriter fw = new FileWriter("results.csv", false)) {
            for (String line : results) {
                fw.write(line + "\n");
            }
            System.out.println("\nResults written to results.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}