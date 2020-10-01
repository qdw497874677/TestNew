package com.qdw.main;

public class MergeSort {
    public void mergeSort(int[] nums,int left,int right,int[] temp){
        if(left<right){
            //分解
            int middle = left + (right - left)/2;
            //治理
            mergeSort(nums, left, middle,temp);
            mergeSort(nums,middle+1,right,temp);
            //合并
            merge(nums,left,middle,right,temp);
        }
    }

    private void merge(int[] nums, int left, int middle, int right,int[] temp) {
        //将辅助数组赋值，帮助nums排序
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = middle+1;
        //比较两个小数组相应下标位置的数组大小，小的先放进数组
        for (int k = left; k <= right; k++) {
            if (i==middle+1){
                nums[k] = temp[j++];
            }else if (j==right+1){
                nums[k] = temp[i++];
            }else if (temp[i]<=temp[j]){
                nums[k] = temp[i++];
            }else {
                nums[k] = temp[j++];
            }
        }

    }

    public static void main(String[] args){
        MergeSort mergeSort = new MergeSort();
        int [] nums = new int[]{90,3,2,67,44,-9,87,65,11,9,2,8};
        //辅助数组，存放过程的数据
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        mergeSort.mergeSort(nums, 0, nums.length-1,temp);
        for(int n:nums){
            System.out.print(" "+n);
        }
    }

}
