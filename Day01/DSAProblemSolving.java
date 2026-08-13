package Day01;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DSAProblemSolving {

    public static void main(String[] args) {

        int arr[]={1,2,3,4,5,6,7,8,9,7};

        //Find Sum
        int arr1[]=findTwoSum(arr, 13);
        System.out.println("["+arr[arr1[0]]+","+arr[arr1[1]]+"]");
        System.out.println("Is Content Duplicate:- "+isContentDuplicate(arr));

        int stock[]={20,10,5,30,4,3,2,1};
        System.out.println(bestTimeToBuySellStock(stock));

        int arr2[]={1,1,2,3,3,4,4,4,5,6,7,7,8,9,9};
        int val=removeDuplicate(arr2);
        System.out.println("Removed Duplicate Array Value");

        for (int i = 0; i < val; i++) {
            System.out.print(arr2[i] + " ");
        }

        // Find max Sum
        System.out.println();
        System.out.println("*************************");
        int arr3[]={-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("Max Sum:-"+findMaxSum(arr3));

        //****************        Merge Intervals    ************         */

        System.out.println("****************        Merge Intervals    ************");

        int arr4[][]={ {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}};

       int arrResult[][]= mearge(arr4);

       for(int[] aa:arrResult)
       {
            System.out.println(Arrays.toString(aa));
       }
       

    }

// Easy
// Two Sum
public static int[] findTwoSum(int arr[], int target)
{
    HashMap<Integer,Integer> map=new HashMap<>();
    for(int i=0;i<arr.length;i++)
    {
        int required=target-arr[i];
        if(map.containsKey(required))
        {
            return new int[]{map.get(required),i};
        }
        else 
        {
            map.put(arr[i], i);
        }
    }
    return new int[]{};
}
// Contains Duplicate

public static boolean isContentDuplicate(int arr[])
{
    Set<Integer> set =new HashSet<>();
    for(int a:arr)
    {
        if(set.contains(a))
        {
            return true;
        }
        set.add(a);
    }
    return false;
}

// Best Time to Buy and Sell Stock
public static int bestTimeToBuySellStock(int arr[])
{
    int buy=arr[0];
    int maxProfit=0;
    for(int i=0;i<arr.length;i++)
    {
        // if(buy>arr[i])
        // {
        //     buy=arr[i];
        // }
        buy=Math.min(buy,arr[i]);
        // if(maxProfit<arr[i]-buy)
        // {
        //     maxProfit=arr[i]-buy;
        // }
        maxProfit=Math.max(maxProfit, arr[i]-buy);
    }
    return maxProfit;

}
// Remove Duplicates from Sorted Array
// Sorted Array Required
// Time Complexity  = O(n)
// Space Complexity = O(1)
public static int removeDuplicate(int arr[])
{
    int i=0;
    for(int j=1;j<arr.length;j++)
    {
        if(arr[j]!=arr[i])
        {
            i++;
            arr[i]=arr[j];
        }
    }
    return i+1;
}
 

// Medium
// Maximum Subarray

public static int findMaxSum(int arr[])
{
    int currentSum=arr[0];
    int maxSum=arr[0];

    for(int i=1;i<arr.length;i++)
    {
        currentSum=Math.max(arr[i], currentSum+arr[i]);

        maxSum=Math.max(maxSum, currentSum);
    }
    return maxSum;
}

// Merge Intervals

    public static int[][] mearge(int intervel[][])
    {
        Arrays.sort(intervel,(a,b)->Integer.compare(a[0], b[0]));

        List<int[]> result=new ArrayList<>();

        int start=intervel[0][0];
        int end =intervel[0][1];

        for(int i=1;i<intervel.length;i++)
        {
            //ovelap
            if(intervel[i][0]<end)
            {
                end=Math.max(intervel[i][1], end);
            }
            else{
                //No Overlap
                result.add(new int[]{start,end});
                start=intervel[i][0];
                end=intervel[i][1];
            }
        }
        result.add(new int[]{start,end});
        return result.toArray(new int[result.size()][]);

    }
}
