package com.qdw.changjingti;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @PackageName:com.qdw.changjingti
 * @ClassName: Test1
 * @Description:
 * @date: 2020/10/31 0031 17:00
 */
public class Test1 {

    public static void main(String[] args) {
        for (Integer integer : divideRedPackage(20, 5)) {
            System.out.println(integer);
        }
    }

    public static List<Integer> divideRedPackage(Integer totalAmount, Integer totalPeopleNum) {
        List<Integer> amountList = new ArrayList<Integer>();
        Integer restAmount = totalAmount;
        Integer restPeopleNum = totalPeopleNum;
        Random random = new Random();
        for (int i = 0; i < totalPeopleNum - 1; i++) {
            //随机范围：[1，剩余人均金额的2倍-1] 分
            int amount = random.nextInt(restAmount / restPeopleNum * 2 - 1) + 1;
            restAmount = restAmount - amount;
            restPeopleNum--;
            amountList.add(amount);
        }
        amountList.add(restAmount);

        return amountList;
    }
}
