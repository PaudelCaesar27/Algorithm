package lab3;

import java.util.Arrays;

public class BubbleSort1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 12, 3, 5, 7, 8, 11, 15, 58};
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }
    /* Here because arr is already sorted
       so it will break after first loop
       only one time the for loop will execute
       so the runtime is O(n) */
    private static int[] bubbleSort(int[] arr) {
        int len = arr.length;
        boolean swapped = false;
        for (int i = 0; i < len; i++)
        { // If two consecutive elements aren't in order, swap them
            for (int j = 0; j < len-1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two consecutive elements were
            // swapped by inner loop, then break
            if (!swapped)
                break;
        }
        return arr;
    }
}
