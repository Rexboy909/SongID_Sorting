import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class entry {
    private static final ArrayList<String> results = new ArrayList<>();

    public static void main(String[] args) {
        results.add("Algorithm,Time (nanoseconds),Time (milliseconds)");
        results.add("");
        runAllTestsForDataset("1000 SONGS", "data/songs1k.csv", 1000);
        results.add("");
        runAllTestsForDataset("10000 SONGS", "data/songs10k.csv", 10000);
        writeResultsToCSV();
    }

    private static void runAllTestsForDataset(String label, String filePath, int numLines) {
        CSVReader reader = new CSVReader();
        ArrayList<Song> songs = reader.readSongs(filePath, numLines);
        results.add(label + ",,");
        testSearchAlgorithms(songs);
        testSortAlgorithms(songs);
        testSortByDate(songs);
    }

    private static void testSearchAlgorithms(ArrayList<Song> songs) {
        System.out.println("=== SEARCH ALGORITHMS ===");
        testSequentialSearch(songs);
        testBinarySearch(songs);
    }

    private static void testSortAlgorithms(ArrayList<Song> songs) {
        System.out.println("\n=== SORTING ALGORITHMS ===");
        testMergeSort(songs);
        testQuickSort(songs);
        testHeapSort(songs);
        testBubbleSort(songs);
        testInsertionSort(songs);
        testSelectionSort(songs);
    }

    private static void testSortByDate(ArrayList<Song> songs) {
        System.out.println("\n=== SORTING ALGORITHMS (By Date Added) ===");
        testMergeSortByDate(songs);
        testQuickSortByDate(songs);
        testHeapSortByDate(songs);
        testBubbleSortByDate(songs);
        testInsertionSortByDate(songs);
        testSelectionSortByDate(songs);
    }

    private static void testSequentialSearch(ArrayList<Song> songs) {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        long time = Timer.timeSearch(() -> Search.sequentialSearch(testSongs, 5000));
        recordResult("Sequential Search", time);
    }

    private static void testBinarySearch(ArrayList<Song> songs) {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        Sort.mergeSort(testSongs);
        long time = Timer.timeSearch(() -> Search.binarySearch(testSongs, 5000));
        recordResult("Binary Search", time);
    }

    private static void testMergeSort(ArrayList<Song> songs) {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        long time = Timer.timeSort(() -> Sort.mergeSort(testSongs));
        recordResult("Merge (By Playcount)", time);
    }

    private static void testQuickSort(ArrayList<Song> songs) {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        long time = Timer.timeSort(() -> Sort.quickSort(testSongs));
        recordResult("Quick (By Playcount)", time);
    }

    private static void testHeapSort(ArrayList<Song> songs) {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        long time = Timer.timeSort(() -> Sort.heapSort(testSongs));
        recordResult("Heap (By Playcount)", time);
    }

    private static void testMergeSortByDate(ArrayList<Song> songs) {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        long time = Timer.timeSort(() -> Sort.mergeSortByDate(testSongs));
        recordResult("Merge (By Date)", time);
    }

    private static void testQuickSortByDate(ArrayList<Song> songs) {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        long time = Timer.timeSort(() -> Sort.quickSortByDate(testSongs));
        recordResult("Quick (By Date)", time);
    }

    private static void testHeapSortByDate(ArrayList<Song> songs) {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        long time = Timer.timeSort(() -> Sort.heapSortByDate(testSongs));
        recordResult("Heap (By Date)", time);
    }

    private static void testBubbleSort(ArrayList<Song> songs) {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        long time = Timer.timeSort(() -> Sort.bubbleSort(testSongs));
        recordResult("Bubble (By Playcount)", time);
    }

    private static void testInsertionSort(ArrayList<Song> songs) {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        long time = Timer.timeSort(() -> Sort.insertionSort(testSongs));
        recordResult("Insertion (By Playcount)", time);
    }

    private static void testSelectionSort(ArrayList<Song> songs) {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        long time = Timer.timeSort(() -> Sort.selectionSort(testSongs));
        recordResult("Selection (By Playcount)", time);
    }

    private static void testBubbleSortByDate(ArrayList<Song> songs) {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        long time = Timer.timeSort(() -> Sort.bubbleSortByDate(testSongs));
        recordResult("Bubble (By Date)", time);
    }

    private static void testInsertionSortByDate(ArrayList<Song> songs) {
        ArrayList<Song> testSongs = new ArrayList<>(songs);
        long time = Timer.timeSort(() -> Sort.insertionSortByDate(testSongs));
        recordResult("Insertion (By Date)", time);
    }

    private static void testSelectionSortByDate(ArrayList<Song> songs) {
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