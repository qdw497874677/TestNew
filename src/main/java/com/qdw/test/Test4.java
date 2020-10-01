package com.qdw.test;



public class Test4 {
    public static void main(String[] args) {
        int[] arr = {2,5,3,6,4,1};
        fast(arr,0,5);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
    public static int[] fast(int[] arr,int left,int right){

        if (left<right){
            int mid = part(arr, left, right);
            fast(arr,left,mid-1);
            fast(arr,mid+1,right);
        }
        return arr;
    }
    public static int part(int[] arr,int left,int right){
        int base = arr[left];
        while (left<right){
            while (left<right && arr[right]>=base){
                right--;
            }
            if (left<right){
                arr[left++] = arr[right];
            }
            while (left<right && arr[left]<=base){
                left++;
            }
            if (left<right){
                arr[right--] = arr[left];
            }
        }
        arr[left] = base;
        return right;
    }
}
