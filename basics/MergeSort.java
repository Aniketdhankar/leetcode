//Merge Sort is a divide and conquer algorithm. It splits the array into halves, sorts each half recursively, and then merges the sorted halves.
/*| Case           | Complexity |
| -------------- | ---------- |
| **Best Case**  | O(n log n) |
| **Average**    | O(n log n) |
| **Worst Case** | O(n log n) |


 */

public class MergeSort {

    // Function to merge two sorted halves
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        // Merge the temp arrays back into arr[left..right]
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[left..right] using merge()
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Original array:");
        for (int num : arr) System.out.print(num + " ");
        System.out.println();

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        for (int num : arr) System.out.print(num + " ");
    }
}
