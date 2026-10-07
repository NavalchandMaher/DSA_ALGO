package Day03;

import java.lang.classfile.components.ClassPrinter.ListNode;

public class BasicTwoPointer {
    
    public static void main(String[] args) {
        // Your code here
        int[] nums = {1, 2, 3, 4, 5};
        int target = 9;
        twoSum(nums, target);
       
    }

    public static int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1}; // Return -1, -1 if no solution is found
    }

    // fast and slow pointer without ListNode class
    public static int findMiddleNode(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (fast < nums.length && fast + 1 < nums.length) {
            slow++;
            fast += 2;
        }
        return nums[slow]; // Return the middle node value
    }

    //Valid Palindrome using two pointer
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // print longest substring without duplicate characters using two pointer
    public static void printLongestSubstringWithoutDuplicates(String s) {
        int left = 0;
        int maxLength = 0;
        java.util.Set<Character> seen = new java.util.HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            while (seen.contains(currentChar)) {
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(currentChar);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        System.out.println("Length of longest substring without duplicates: " + maxLength);
    }

    // container with most water using two pointer
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
    //Longest Repeating Character Replacement using two pointer
    public static int characterReplacement(String s, int k) {
        int left = 0;
        int maxCount = 0;
        int[] count = new int[26];

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            if (right - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
        }
        return s.length() - left;
    }

}
