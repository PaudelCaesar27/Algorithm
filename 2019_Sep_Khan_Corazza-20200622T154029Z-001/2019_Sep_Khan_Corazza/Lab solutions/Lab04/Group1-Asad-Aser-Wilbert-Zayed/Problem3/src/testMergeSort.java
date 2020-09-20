
import java.util.Random;

public class testMergeSort {
    public static void main(String[] args) {
        int[] test = {10, 100, 1000, 10000, 1000000, 10000000};
        for (int i : test) {
            System.out.println("Total elements: " + i);
            calculateRunningTime(generateRandomArray(i));
            System.out.println();
        }
    }

    private static void calculateRunningTime(int[] arr) {
        long start = 0;
        long end = 0;
        MergeSort ms = new MergeSort();
        MergeSortPlus msp = new MergeSortPlus();

        int[] arrMS = new int[arr.length];
        System.arraycopy(arr, 0, arrMS, 0, arr.length);

        int[] arrMSP = new int[arr.length];
        System.arraycopy(arr, 0, arrMSP, 0, arr.length);

        System.out.println("Merge Sort (ms): ");
        start = System.currentTimeMillis();
        ms.sort(arrMS);
        end = System.currentTimeMillis();
        System.out.println(end - start);

        System.out.println("Merge Sort Plus (ms): ");
        start = System.currentTimeMillis();
        msp.sort(arrMSP);
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static int[] generateRandomArray(int n) {
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(n);
        }
        return arr;
    }
}
