package com.atmm.jedis;

import java.util.Random;
import java.util.Scanner;

/**
 * @ClassName jlj
 * @Author 79360
 * @Date 2022/9/2 14:09
 * @Description TODO
 * @Version 1.0
 **/
public class AAA {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int count = 0;
        for (int i = 2; i >= 0; i--) {
            System.out.print("请输入密码:");
            String next = scanner.next();
            count++;
            if ("我是小黑子鸡辣羊,请让我登录".equals(next)) {
                System.out.println("登录成功");
                break;
            } else if (count <= 2) {
                System.out.println("密码错误,你还有" + i + "次机会");
            } else {
                System.out.println("登录已达最大次数");
                Thread.sleep(1000);
                System.out.println("三秒后将重置操作系统");
                Thread.sleep(3000);
                for (int j = 0; j <= 99; j++) {
                    for (int k = 0; k <= 5; k++) {
                        System.out.println(random.nextInt(999999999));
                        Thread.sleep(5);
                    }
                    System.out.println("正在重置系统%" + j);
                    Thread.sleep(5);
                }
                System.out.println("重置失败,电脑已感染鸡你太美病毒");
                System.out.println("重置失败,电脑已感染鸡你太美病毒");
            }
        }
    }
}
