package com.qdw.douyu;

/**
 * @PackageName:com.qdw.douyu
 * @ClassName: Test2
 * @Description:
 * @date: 2020/11/3 0003 11:42
 */
public class Test2 {
    public static void main(String[] args) {
        int[] arr = {6,5,4,3,2,1};
        fastSort(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

    public static void fastSort(int[] arr,int l,int r){
        if(l<r){
            int mid = part(arr,l,r);
            fastSort(arr,l,mid-1);
            fastSort(arr,mid+1,r);
        }
    }

    public static int part(int[] arr,int l,int r){
        int index = arr[l];
        while(l<r){
            while (l<r && arr[r]>=index){
                r--;
            }
            if(l<r){
                arr[l++] = arr[r];
            }
            while(l<r && arr[l]<=index){
                l++;
            }
            if (l<r){
                arr[r--] = arr[l];
            }
        }
        arr[l] = index;
        return l;

    }
}
