import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new int[]{11, 123, 115}, new int[]{22, 34, 61})));
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int totalLength = arr1.length + arr2.length;
        int[] result = new int[totalLength];

        int arr1Index = 0;
        int arr2Index = 0;
        for (int i = 0; i < totalLength; i++) {
            int small = 0;
            if (arr1Index < arr1.length && arr2Index < arr2.length) {
                if (arr1[arr1Index] < arr2[arr2Index]) {
                    small = arr1[arr1Index];
                    arr1Index++;
                } else {
                    small = arr2[arr2Index];
                    arr2Index++;
                }
            } else {
                if (arr1Index == arr1.length){
                    small = arr2[arr2Index];
                    arr2Index++;
                }
                else{
                    small = arr1[arr1Index];
                    arr1Index++;
                }
            }
            result[i] = small;
        }
        return result;
    }
}
