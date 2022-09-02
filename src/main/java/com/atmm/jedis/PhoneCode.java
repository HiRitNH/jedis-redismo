package com.atmm.jedis;

import redis.clients.jedis.Jedis;

import java.util.Random;

public class PhoneCode {
    public static void main(String[] args) {
        verifyCode("19927603404");
//        getRedisCode("19927603404","469123");
    }

    //1.生成6位数字验证码
    public static String getCode() {
        Random random = new Random();
        String code = "";
        for (int i = 0; i < 6; i++) {
            int rand = random.nextInt(10);
            code += rand;
        }
        return code;
    }

    //2.每个手机每天只能发送三次,验证码放到redis中,设置过期时间
    public static void verifyCode(String phone) {
        Jedis jedis = new Jedis("192.168.179.129", 6379);

        String countKey = phone + "count";
        String codeKey = phone + "code";

        String count = jedis.get(countKey);

        if (count == null) {
            jedis.setex(countKey, 24 * 60 * 60, "1");
        } else if (Integer.parseInt(count) <= 2) {
            jedis.incr(countKey);
        } else if (Integer.parseInt(count) > 2) {
            System.out.println("发送次数已超过3次");
            jedis.close();
            return;
        }
        String code1 = getCode();
        jedis.setex(codeKey, 120, code1);
        jedis.close();
    }

    //3.验证码检验
    public static void getRedisCode(String phone, String code) {
        Jedis jedis = new Jedis("192.168.179.129", 6379);
        String codeKey = phone + "code";
        String redisCode = jedis.get(codeKey);

        if (redisCode.equals(code)) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
        jedis.close();
    }
}