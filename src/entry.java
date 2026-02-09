import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Consumer;

public class entry {
    private static final ArrayList<String> results = new ArrayList<>();
    private static final ArrayList<Song> songs = new ArrayList<>();

    public static void main(String[] args) {
        CSVReader reader = new CSVReader();
        songs.addAll(reader.readSongs("../data/songs10k.csv", 2000));
        
        results.add("Algorithm,Time (nanoseconds),Time (milliseconds)");
        
        testSearchAlgorithms();
        testSortAlgorithms();
        testSortByDate();
        
        writeResultsToCSV();
    }

    private static void testSearchAlgorithms() {
        System.out.println("=== SEARCH ALGORITHMS ===");
        testSearch("Sequential Search", s -> Search.sequentialSearch(s, 5000), false);
        testSearch("Binary Search", s -> Search.binarySearch(s, 5000), true);
    }

    private static void testSortAlgorithms() {
        System.out.println("\n=== SORTING ALGORITHMS ===");
        testSort("Merge (By Playcount)", Sort::mergeSort);
        testSort("Quick (By Playcount)", Sort::quickSort);
        testSort("Heap (By Playcount)", Sort::heapSort);
    }

    private static void testSortByDate() {
        System.out.println("\n=== SORTING ALGORITHMS (By Date Added) ===");
        testSort("Merge (By Date)", Sort::mergeSortByDate);
        testSort("Quick (By Date)", Sort::quickSortByDate);
        testSort("Heap (By Date)", Sort::heapSortByDate);
    }

    private static void testSearch(String name, Consumer<ArrayList<Song>> algorithm, boolean needsSort) {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        if (needsSort) Sort.mergeSort(testSongs);
        
        long time = Timer.timeSearch(() -> algorithm.accept(testSongs));
        recordResult(name, time);
    }

    private static void testSort(String name, Consumer<ArrayList<Song>> algorithm) {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        long time = Timer.timeSort(() -> algorithm.accept(testSongs));
        recordResult(name, time);
    }

    private static void recordResult(String name, long time) {
        double ms = time / 1_000_000.0;
        results.add(name + "," + time + "," + ms);
        System.out.println(name + ": " + time + " ns (" + ms + " ms)");
    }
    
    private static void writeResultsToCSV() {
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