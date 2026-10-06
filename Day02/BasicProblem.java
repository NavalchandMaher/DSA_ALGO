package Day02;

import java.util.*;
public class BasicProblem {
    public static void main(String[] args){

        int arr[]={1,2,3,4,5,6,7,8,9,9,8,9};
        int max=findMax(arr);
        int min=findMin(arr);
        System.out.println("Maximum element is: " + max);
        System.out.println("Minimum element is: " + min);
        reverseArray(arr);
        countFrequency(arr);

    }
    public static int findMax(int[] arr)
    {
        int max=arr[0];
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
            }
        }
        return max;
    }

    public static int findMin(int[] arr)
    {
        int min=arr[0];
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<min)
            {
                min=arr[i];
            }
        }
        return min;
    }

    public static void reverseArray(int arr[])
    {
        int start=0;
        int end=arr.length-1;
        while(start<end)
        {
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        System.out.println("Reversed array is: ");
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void countFrequency(int arr[])
    {
       Map<Integer,Integer> freqMap=new HashMap<>();
       
       for(int i=0;i<arr.length;i++)
       {
           freqMap.put(arr[i],freqMap.getOrDefault(arr[i],0 )+1);;
       }
       System.out.println("Frequency of each element:");
       for(Map.Entry<Integer,Integer> entry: freqMap.entrySet())
       {
              System.out.println(entry.getKey()+":"+entry.getValue());
       }
    }

}
