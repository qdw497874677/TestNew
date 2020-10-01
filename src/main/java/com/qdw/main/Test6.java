package com.qdw.main;

        import java.util.Scanner;
        import java.util.Stack;

public class Test6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            sc.nextLine();
            String ar1 = sc.nextLine();
            String[] s1 = ar1.split(" ");
            int[] arr1 = new int[n];
            for (int j = 0; j < n; j++) {
                arr1[j] = Integer.parseInt(s1[j]);
            }
            int[] ans = new int[n];
            for (int j = 0; j < n; j++) {
                if (j+1<n){
                    for (int k = j+1; k < n && arr1[k]<=arr1[j]; k++) {
                        ans[j]++;
                    }
                }
                if (j-1>=0){
                    for (int k = j-1; k >= 0 && arr1[k]<=arr1[j]; k--) {
                        ans[j]++;
                    }
                }
            }


//            Stack<Integer> stack = new Stack<>();
//            int[] ans = new int[n];
//            for (int j = 0; j < n; j++) {
//                while (!stack.isEmpty() && arr1[stack.peek()]<arr1[j]){
//                    int pop = stack.pop();
//                    ans[pop] += j-pop;
//
//                }
//                if (!stack.isEmpty()){
//                    System.out.println(i+"!");
//                    ans[j] += j-stack.peek();
//                }
//                stack.add(j);
//            }

            for (int an : ans) {
                System.out.print(an+" ");
            }
            System.out.println();
        }
    }
}
