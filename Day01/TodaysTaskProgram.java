package Day01;

public class TodaysTaskProgram {
    public static void main(String[] args) {
        // Write your code here

        System.out.println("Index of 3: " + linearSearch(new int[]{1, 2, 3, 4, 5}, 3));
        System.out.println("Maximum: " + findMaximum(new int[]{1, 2, 3, 4, 5}));
        int[] arr = {1, 2, 3, 4, 5};
        reverseArray(arr);
        System.out.println("Reversed Array: " + java.util.Arrays.toString(arr));
        System.out.println("Index of 3: " + binarySearch(new int[]{1,   2, 3, 4, 5}, 3));   
        System.out.println("Second Largest: " + secondLargest(new int[]{1, 2, 3, 4, 5}));
    }
    

// Linear Search (time complexity O(n) and space complexity O(1))
public static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i; // Return the index of the target element
        }
    }
    return -1; // Return -1 if the target is not found
}
// Find Maximum (time complexity O(n) and space complexity O(1))
public static int findMaximum(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    return max;
}
// Reverse Array using two pointers (time complexity O(n) and space complexity O(1))
public static void reverseArray(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    while (left < right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++;
        right--;
    }
}
// Binary Search (time complexity O(log n) and space complexity O(1)) - Note: The array must be sorted for binary search to work correctly
public static int binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) {
            return mid; // Return the index of the target element
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1; // Return -1 if the target is not found
}
// Second Largest Element (time complexity O(n) and space complexity O(1))
public static int secondLargest(int[] arr) {
    int largest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;
    for (int num : arr) {
        if (num > largest) {
            secondLargest = largest;
            largest = num;
        } else if (num > secondLargest && num != largest) {
            secondLargest = num;
        }
    }
    return secondLargest;

}
}