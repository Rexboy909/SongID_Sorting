public class Timer {

    public static long timeSearch(Runnable search) {
        long start = System.nanoTime();
        search.run();
        return System.nanoTime() - start;
    }

    public static long timeSort(Runnable sort) {
        long start = System.nanoTime();
        sort.run();
        return System.nanoTime() - start;
    }
}
