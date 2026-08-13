package Day01;

import java.util.Arrays;

public class JavaImplPractice {
    public static void main(String[] args) {

        int arr[]={1,2,3,4,5,6,7,8,9};
        int index=linerSearch(arr, 7);
        System.out.println("Linear Serch Value Index:- "+index);

        int binaryIndex=binarySearch(arr, 7);
        System.out.println("Binary Serch Value Index:- "+binaryIndex);
        reverseArray(arr);

        System.out.println("Print Max Value:-"+findMax(arr));

        System.out.println("Print second Max:-"+findSecondMax(arr));
    }
    //Time: O(n)
    //Space: O(1)
    public static int linerSearch(int arr[],int target)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==target)
            {
                return i;
            }
        }
        return -1;
    }
    //Time: O(log n)
    //Space: O(1)
    public static int binarySearch(int arr[],int target)
    {
        int left =0;
        int right=arr.length-1;
        while(left<=right)
        {
            int mid=right-left/2;
            if(arr[mid]==target)
            {
                return mid;
            }
            else if(mid < target)
            {
                left =mid+1;
            }
            else
            {
                right=mid-1;
            }
        }
        return -1;
    }

    // Time: O(n)
    //Space: O(1)
    public static void reverseArray(int arr[])
    {

        int left=0;
        int right=arr.length-1;
        while(left<right)
        {
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
        System.out.println("Reverse Array Using two pointer:- ");
        System.out.println(Arrays.toString(arr));
    }

    //Time: O(n)
    //Space: O(1)
    public static int findMax(int arr[])
    {
        int max=arr[0];
        for(int i=0;i<arr.length;i++)
        {
            if(max<arr[i])
            {
                max=arr[i];
            }
        }
        return max;
    }

    //Time: O(n)
    //Space: O(1)
    public static int findSecondMax(int arr[])
    {
        int max=arr[0];
        int secondMax=0;
        for(int i=0;i<arr.length;i++)
        {
            if(max<=arr[i] )
            {
                max=arr[i];
            }
            else if (secondMax!=max && secondMax<=arr[i])
            {
                    secondMax=arr[i];
            }
        }
        return secondMax;
    }

    }