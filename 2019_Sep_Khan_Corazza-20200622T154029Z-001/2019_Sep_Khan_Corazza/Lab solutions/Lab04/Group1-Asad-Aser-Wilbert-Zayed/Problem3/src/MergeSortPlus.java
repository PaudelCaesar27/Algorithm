import java.util.Arrays;

public class MergeSortPlus {

    public static void main(String[] args) {
        int[] arr = {1, 58, 2, 12, 31, 44, 4, 3, 5, 7, 8, 11, 15, 13};
        MergeSortPlus msp = new MergeSortPlus();

        System.out.println("Original array: " + Arrays.toString(arr));
        msp.sort(arr);
        System.out.println("Sorted array:   " + Arrays.toString(arr));
    }

    // global storage to hold the sorted array
    private int[] sortedArray;

    // public sorter
    public int[] sort(int[] input) {
        int n = input.length;
        int[] tempStorage = new int[n];
        sortedArray = input;
        mergeSort(tempStorage, 0, n - 1);
        return sortedArray;
    }

    // mergeSort(array, lowerbound, upperbound)
    private void mergeSort(int[] array, int lb, int ub) {
        if (lb == ub) {
            return;
        }
        int THRESHOLD = 20;
        // constant of an array with 20 or fewer elements
        if ((ub - lb) <= THRESHOLD) {
            insertionSort(lb, ub);
        } else {
            int mid = (lb + ub) / 2;
            // sort left half
            mergeSort(array, lb, mid);
            // sort right half
            mergeSort(array, mid + 1, ub);
            // merge left and right
            merge(array, lb, mid + 1, ub);
        }
    }

    // insertionSort(lowerbound, upperbound)
    private void insertionSort(int lb, int ub) {
        if (sortedArray == null || sortedArray.length < 2) {
            return;
        }
        int len = ub + 1;
        int tmp;
        int j;
        for (int i = lb; i < len; i++) {
            tmp = sortedArray[i];
            j = i;
            while (j > lb && tmp < sortedArray[j - 1]) {
                sortedArray[j] = sortedArray[j - 1];
                j--;
            }
            sortedArray[j] = tmp;
        }
    }

    // merge 2 arrays: [lowerPointer, upperPointer - 1] and [upperPointer,
    // upperBound]
    private void merge(int[] array, int lp, int up, int ub) {
        // lower bound
        int lb = lp;
        // total elements need to be re-arrange
        int n = ub - lb + 1;
        int mid = up - 1;
        // merge [lowerBound, mid] and [mid + 1, upperBound]
        int j = 0; //index of array
        while (lp <= mid && up <= ub) {
            if (sortedArray[lp] < sortedArray[up]) {
                array[j++] = sortedArray[lp++];
            } else {
                array[j++] = sortedArray[up++];
            }
        }
        // left array might still have elements
        while (lp <= mid) {
            array[j++] = sortedArray[lp++];
        }
        // right array might still have elements
        while (up <= ub) {
            array[j++] = sortedArray[up++];
        }
        //replace the range [lowerBound, upperBound] in sortedArray with
        //the range [0, n-1] just created in array
        for (j = 0; j < n; ++j) {
            sortedArray[lb + j] = array[j];
        }
    }
}