package com.atmm.jedis;

import java.util.Scanner;

/**
 * @ClassName jlj
 * @Author 79360
 * @Date 2022/9/2 14:09
 * @Description TODO
 * @Version 1.0
 **/
public class AAA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int i = 3;
            System.out.print("请输入密码:");
            String next = scanner.next();
            if ("我是鸡辣羊,请开门".equals(next)) {
                System.out.println("登录成功");
                break;
            } else {
                --i;
                System.out.println("密码错误,你还有" + i + "次机会");
            }
            System.out.println();
            System.out.println();
        }
    }
}