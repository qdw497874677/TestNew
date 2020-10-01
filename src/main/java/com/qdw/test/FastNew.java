package com.qdw.test;

import java.util.Random;

public class FastNew {
    public static void main(String[] args) {
//        int[] arr = {9,2,1,5,2,6,3,4};
        int[] arr = {9,6,5,2,7,3,1};
//        int[] ints = fast(arr, 0, 6);
        int[] ints = fast2(arr, 0, 6);
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
    public static int[] fast2(int[] arr,int left,int right){
        if (left<right){
            int index = partiton(left,right,left,arr);
            fast(arr,left,index-1);
            fast(arr,index+1,right);
        }
        return arr;
    }
    public static int partiton(int left,int right,int pivotIndex,int[] nums){
//        Random random = new Random();
//        int i = random.nextInt(right - left);
//        System.out.println(left+" "+right+" "+nums[i]);
        int pivot = nums[pivotIndex];
        while (left<right){
            while (left<right && nums[right]>=pivot){
                right--;
            }
//            if (left<right){
//                System.out.println("!"+nums[right]);
//                nums[left++] = nums[right];
//            }
            while (left<right && nums[left]<=pivot){
                left++;
            }
            if (left<right){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
//                nums[right--] = nums[left];
            }
        }
        nums[left] = pivot;
        return left;
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
