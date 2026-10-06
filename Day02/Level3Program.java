package Day02;
import java.util.*;
import java.util.stream.Collectors;
public class Level3Program {
    public static void main(String[] args) {
        // Your code here

        firstUniqueCharacter("leetcode");
        firstUniqueCharacterUsingStream("leetcode");
        System.out.println("Majority Element: " + majorityElement(new int[]{3, 2, 3}));
        System.out.println("Majority Element (Boyer-Moore): " + majorityElementBoyerMoore(new int[]{3, 2, 3})); 

    }

     // first unique character in a string
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

    // first unique character using stream
    public static char firstUniqueCharacterUsingStream(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey())
                .findFirst()
                .orElse('\0'); // Return null character if no unique character is found
    }

    //Majority Element
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (HashMap.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return -1; // Return -1 if no majority element is found
    }

    //Majority Element using Boyer-Moore Voting Algorithm
    public static int majorityElementBoyerMoore(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // Verify if the candidate is indeed the majority element
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        return count > nums.length / 2 ? candidate : -1; // Return -1 if no majority element is found
    }

}