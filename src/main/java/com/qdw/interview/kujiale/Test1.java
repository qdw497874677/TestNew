package com.qdw.interview.kujiale;

import java.io.*;
import java.util.Scanner;

/**
 * @PackageName:com.qdw.kujiale
 * @ClassName: Test1
 * @Description:
 * @date: 2020/5/26 0026 10:23
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        SystemDemo sd = new SystemDemo();
//        File file = new File("/text.txt");
//        BufferedReader br = new BufferedReader(new FileReader(file));
//        String s = null;
//
//        while ((s = br.readLine())!=null){
//            String name = s.split(" ")[0];
//            Integer id = Integer.parseInt(s.split(" ")[1]);
//            sd.buy(new IdCard(id,name));
//        }
        while (true){
            System.out.println("1.买票\n2.检票\n3.退票\n请输入对应操作的序号：");
            int index = sc.nextInt();
            if (index == 1){
                System.out.println("请输入姓名：");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.println("请输入身份证号码：");

                Integer id = sc.nextInt();
                IdCard idCard = new IdCard(id, name);
                sd.buy(idCard);
            }else if (index == 2){
                System.out.println("请输入身份证号码：");
                Integer id = sc.nextInt();
                IdCard idCard = new IdCard(id, "");
                sd.check(idCard);
            }else if(index == 3){
                System.out.println("请输入身份证号码：");
                Integer id = sc.nextInt();
                IdCard idCard = new IdCard(id, "");
                sd.back(idCard);
            }


        }



//        SystemDemo sd = new SystemDemo();
//        IdCard ic = new IdCard(123456789, "张三");
//        Ticket ticket = sd.buy(ic);
//        sd.check(ticket);
//        sd.back(ic);
    }
}
