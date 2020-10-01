package com.qdw.paixu;

import com.qdw.main.MergeSort;

import java.util.Random;

/**
 * @PackageName:com.qdw.paixu
 * @ClassName: Test1
 * @Description:
 * @date: 2020/9/16 0016 21:08
 */
public class Test1 {
    public void mergeSort(int[] nums,int left,int right,int[] temp){
        if(left<right){
            //分解
            int middle = left + (right - left)/2;
            //治理
            mergeSort(nums, left, middle,temp);
            mergeSort(nums,middle+1,right,temp);
            if (nums[middle]<=nums[middle+1]){
                System.arraycopy(temp, left, nums, left, right-left+1);
                return;
            }
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
        int n = 100;
        int[] nums = new int[n];
//        int [] nums = new int[]{90,3,2,67,44,-9,87,65,11,9,2,8};
        Random random = new Random();
        for (int i = 0; i < n; i++) {
//            nums[i] = random.nextInt(100000);
            nums[i] = i;
        }
        //辅助数组，存放过程的数据
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        long start = System.currentTimeMillis();
        mergeSort.mergeSort(nums, 0, nums.length-1,temp);
        System.out.println("耗时："+(System.currentTimeMillis()-start));
        for(int num:nums){
            System.out.print(" "+num);
        }
    }
}
