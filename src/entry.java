import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
        testSequentialSearch();
        testBinarySearch();
    }

    private static void testSortAlgorithms() {
        System.out.println("\n=== SORTING ALGORITHMS ===");
        testMergeSort();
        testQuickSort();
        testHeapSort();
        testBubbleSort();
        testInsertionSort();
        testSelectionSort();
    }

    private static void testSortByDate() {
        System.out.println("\n=== SORTING ALGORITHMS (By Date Added) ===");
        testMergeSortByDate();
        testQuickSortByDate();
        testHeapSortByDate();
        testBubbleSortByDate();
        testInsertionSortByDate();
        testSelectionSortByDate();
    }

    private static void testSequentialSearch() {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        long time = Timer.timeSearch(() -> Search.sequentialSearch(testSongs, 5000));
        recordResult("Sequential Search", time);
    }

    private static void testBinarySearch() {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        Sort.mergeSort(testSongs);
        long time = Timer.timeSearch(() -> Search.binarySearch(testSongs, 5000));
        recordResult("Binary Search", time);
    }

    private static void testMergeSort() {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        long time = Timer.timeSort(() -> Sort.mergeSort(testSongs));
        recordResult("Merge (By Playcount)", time);
    }

    private static void testQuickSort() {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        long time = Timer.timeSort(() -> Sort.quickSort(testSongs));
        recordResult("Quick (By Playcount)", time);
    }

    private static void testHeapSort() {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        long time = Timer.timeSort(() -> Sort.heapSort(testSongs));
        recordResult("Heap (By Playcount)", time);
    }

    private static void testMergeSortByDate() {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        long time = Timer.timeSort(() -> Sort.mergeSortByDate(testSongs));
        recordResult("Merge (By Date)", time);
    }

    private static void testQuickSortByDate() {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        long time = Timer.timeSort(() -> Sort.quickSortByDate(testSongs));
        recordResult("Quick (By Date)", time);
    }

    private static void testHeapSortByDate() {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        long time = Timer.timeSort(() -> Sort.heapSortByDate(testSongs));
        recordResult("Heap (By Date)", time);
    }

    private static void testBubbleSort() {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        long time = Timer.timeSort(() -> Sort.bubbleSort(testSongs));
        recordResult("Bubble (By Playcount)", time);
    }

    private static void testInsertionSort() {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        long time = Timer.timeSort(() -> Sort.insertionSort(testSongs));
        recordResult("Insertion (By Playcount)", time);
    }

    private static void testSelectionSort() {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        long time = Timer.timeSort(() -> Sort.selectionSort(testSongs));
        recordResult("Selection (By Playcount)", time);
    }

    private static void testBubbleSortByDate() {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        long time = Timer.timeSort(() -> Sort.bubbleSortByDate(testSongs));
        recordResult("Bubble (By Date)", time);
    }

    private static void testInsertionSortByDate() {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        long time = Timer.timeSort(() -> Sort.insertionSortByDate(testSongs));
        recordResult("Insertion (By Date)", time);
    }

    private static void testSelectionSortByDate() {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        long time = Timer.timeSort(() -> Sort.selectionSortByDate(testSongs));
        recordResult("Selection (By Date)", time);
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