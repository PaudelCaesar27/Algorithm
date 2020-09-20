package lab3;

import java.util.Arrays;

public class BubbleSort2 {
    public static void main(String[] args) {
        int[] arr = {1, 58, 2, 12, 31, 44, 4, 3, 5, 7, 8, 11, 15, 0,13};
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }
    /*because the after 1st loop the largest element will be in the last position
      each loop will bring the large element to the end
      So we can skip the checking of element who are already larger than others
      this will cut the running time in half */
    private static int[] bubbleSort(int[] arr) {
        int len = arr.length;
        boolean swapped = false;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
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
