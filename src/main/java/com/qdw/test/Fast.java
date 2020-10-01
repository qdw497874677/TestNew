package com.qdw.test;

public class Fast {

    public static void main(String[] args) {
        int[] arr = {9,2,1,5,2,6,3,4};
        int[] ints = fast(arr, 0, 7);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
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
    static int part(int[] n,int l,int r ){
        int index = n[l];
        while(l<r){
            while(l<r && n[r]>=index){
                r--;
            }
            if (l<r){
                n[l++] = n[r];
            }
            while(l<r && n[l]<=index){
                l++;
            }
            if (l<r){
                n[r--] = n[l];
            }
        }
        n[l] = index;
        return l;
    }









    static int part2(int[] n, int left, int right) {
        int pivot = n[left];
        while (left < right) {
            //右指针向左滑动找到比基准小的值
            while (left < right && n[right] >= pivot){
                right--;
            }
            //把这个值放到左指针的位置，左指针++
            if (left < right){
                n[left++] = n[right];
            }
            //左指针向右滑动找到比基准大的值
            while (left < right && n[left] <= pivot){
                left++;
            }
            //把这个值放到右指针的位置，右指针--
            if (left < right){
                n[right--] = n[left];
            }
        }
        //留出来的位置放基准数
        n[left] = pivot;
        //返回基准的位置
        return left;
    }
}
