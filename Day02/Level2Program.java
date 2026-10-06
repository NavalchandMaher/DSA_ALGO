package Day02;

import java.util.*;

public class Level2Program {
    public static void main(String[] args){

        int arr[]=(new int[]{1,2,3,4,5,6,7,8,9,9,8,9});
        boolean result = containsDuplicate(arr);
        System.out.println(result);

        twoSum(arr, 10);
        twoSumUsingHashMap(arr, 10);

    }

    public static boolean containsDuplicate(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int num :arr){
            if(set.contains(num))
            {
                return true;
            }
            else{
                set.add(num);
            }
        }
        return false;
    }

    public static void twoSum(int arr[],int target)
    {
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i]+arr[j]==target)
                {
                    System.out.println("Pair found: (" + arr[i] + ", " + arr[j] + ")");
                    return;
                }
            }
        }
        System.out.println("No pair found.");
    }

    public static void twoSumUsingHashMap(int arr[],int target)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            int complement=target-arr[i];
            if(map.containsKey(complement))
            {
                System.out.println("Pair found: (" + arr[i] + ", " + complement + ")");
                return;
            }
            map.put(arr[i],i);
        }
        System.out.println("No pair found.");
    }

    //Intersection of Two Arrays
    public static void intersectionOfTwoArrays(int arr1[], int arr2[]) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int num : arr1) {
            set1.add(num);
        }

        HashSet<Integer> intersection = new HashSet<>();
        for (int num : arr2) {
            if (set1.contains(num)) {
                intersection.add(num);
            }
        }

        System.out.println("Intersection of the two arrays: " + intersection);
    }

    // first uniquw character in a string
    public static char firstUniqueCharacter(String s) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            if (charCountMap.get(c) == 1) {
                return c;
            }
        }
        return '\0'; // Return null character if no unique character is found
    }
}
