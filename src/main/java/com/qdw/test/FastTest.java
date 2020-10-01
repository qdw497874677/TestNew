package com.qdw.test;

public class FastTest {
    public static void main(String[] args) {
        int[] arr = {9,6,5,2,7,3,1};
        int[] fast = fast(arr, 0, 6);
        for (int i : fast) {
            System.out.print(i+" ");
        }
    }

    public static int[] fast(int[] arr,int left,int right){
        if (left<right){
            int index = part(arr,left,right);
            fast(arr,left,index-1);
            fast(arr,index+1,right);
        }
        return arr;
    }
    public static int part(int[] arr,int left,int right){
        int index = arr[left];
        while (left<right){
            while (left<right && arr[right]>=index){
                right--;
            }
            if (left<right){
                arr[left] = arr[right];
                left++;
            }
            while (left<right && arr[left]<=index){
                left++;
            }
            if (left<right){
                arr[right] = arr[left];
                right--;
            }

        }
        arr[left] = index;
        return left;

    }
}
