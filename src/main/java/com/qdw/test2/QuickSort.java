package com.qdw.test2;
//快排
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {9,2,1,5,2,6,3,4};
        int[] ints = fast(arr, 0, 7);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }
    public static int[] fast(int[] arry,int first,int last) {
        if(last > first) {
            int pivotIndex = fastvoid(arry,first,last);
            fast(arry,first,pivotIndex-1);//前半部分
            fast(arry,pivotIndex+1,last);//后半部分
        }
        return arry;
    }

    public static int fastvoid(int[] arry,int first,int last) {
        //以第一个数作为基准
        int privot = arry[first];
        int low = first + 1;
        int high = last;
        while(low < high) {
            //前面的找比基数大的
            while(low <= high && arry[low] <= privot) {
                low++;
            }
            //后面找比基数小的
            while(low <= high && arry[high] >= privot) {
                high--;
            }
            //如果两个指针的位置是high在low后面，就交换他们指向的值
            if(high > low) {
                int temp = arry[high];
                arry[high] = arry[low];
                arry[low] = temp;
            }
        }
        //把high指针移动到，指针所在的值刚刚小于基准数（除非到头了说明基准是这里最小的）
        while(high > first && arry[high] >= privot) {
            high--;
        }
        //如果中间位置的值比基准小，交换基准数和中间数
        //保证中间的数的位置是正确的
        if(privot > arry[high]) {
            arry[first] = arry[high];
            arry[high] = privot;
            //返回中间位置
            return high;
        }else {
            //返回最左边的位置
            return first;
        }
    }



}
