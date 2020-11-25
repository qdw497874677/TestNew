package com.qdw.test;

import java.util.Scanner;

/**
 * @PackageName:com.qdw.test
 * @ClassName: Test7
 * @Description:
 * @date: 2020/10/15 0015 9:53
 */
public class Test7 {
    public static void main(String[] args) {
        point[] points = new point[3];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {

            if (i % 2 == 0){
                point point = new point();
                point.setX(scanner.nextInt());
                points[i / 2] = point;
            }else {
                point point = new point();
                point.setY(scanner.nextInt());
                points[i / 2] = point;
            }

        }
        if ((points[1].getY() - points[0].getY()) * (points[2].getX() - points[1].getX()) == (points[1].getX() - points[0].getX()) * (points[2].getY() - points[1].getY())) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }
}

class point {
    private int x;
    private int y;

    public point() {
    }

    public point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

