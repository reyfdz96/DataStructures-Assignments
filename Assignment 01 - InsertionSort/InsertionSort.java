import java.util.Arrays;

/**
 * InsertionSort
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] myList = {2, 9, 5, 4, 8, 1, 6};
        System.out.println(Arrays.toString(myList));

        insertionSort(myList);
        System.out.println(Arrays.toString(myList));

    }

    public static int[] insertionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }

        return arr;
    }
}