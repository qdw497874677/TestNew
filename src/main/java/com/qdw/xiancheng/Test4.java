package com.qdw.xiancheng;

/**
 * @PackageName:com.qdw.xiancheng
 * @ClassName: Test4
 * @Description:
 * @date: 2020/10/17 0017 14:56
 */
public class Test4 {
    public static void main(String[] args) {

        Test4 test4 = new Test4();
        int[] arr = {42,35,63,96,56,11,17,42,88};
        int n = 3;
        test4.nthResultOfQuickSort(arr,n);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

    public int[] nthResultOfQuickSort (int[] array, int n) {
        // write code here
        return fastSort(array,0,array.length-1,n);
    }
    public int[] fastSort(int[] array,int l,int r,int n){
        if(n==0){
            return array;
        }
        if(l<r){
            int mid = partition(array,l,r);
            n--;
            fastSort(array,l,mid-1,n);
            fastSort(array,mid+1,r,n);
        }
        return array;
    }
    public int partition(int[] array,int l,int r){
        int base = array[l];
        while(l<r){
            while(l<r && array[r]>=base){
                r--;
            }
            if(l<r){
                array[l++] = array[r];
            }
            while(l<r && array[l]<=base){
                l++;
            }
            if(l<r){
                array[r--] = array[l];
            }
        }
        array[l] = base;
        return l;
    }
}
