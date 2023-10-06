package com.atmm.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class JedisDemo1 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.111.128", 6379);
        String ping = jedis.ping();
        System.out.println(ping);
    }

    @Test
    public void demo1() {
        Jedis jedis = new Jedis("192.168.111.128", 6379);
        jedis.set("name", "lucy");
        String name = jedis.get("name");
        System.out.println(name);
        jedis.mset("k1", "v1", "k2", "v2");
        List<String> mget = jedis.mget("k1", "k2");
        System.out.println(mget);
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
    }

    @Test
    public void demo2() {
        Jedis jedis = new Jedis("192.168.179.129", 6379);
        jedis.lpush("key1", "lucy", "mary", "jack");
        List<String> key = jedis.lrange("key1", 0, -1);
        System.out.println(key);
    }

    @Test
    public void demo3() {
        Jedis jedis = new Jedis("192.168.179.129", 6379);
        jedis.sadd("names", "lucy", "jack");
        Set<String> name = jedis.smembers("names");
        System.out.println(name);
    }

    @Test
    public void demo4() {
        Jedis jedis = new Jedis("192.168.179.129", 6379);
        jedis.hset("users", "age", "20");
        String hget = jedis.hget("users", "age");
        System.out.println(hget);
    }

    @Test
    public void demo5() {
        Jedis jedis = new Jedis("192.168.179.129", 6379);
        jedis.zadd("china", 100d, "shanghai");
        Set<String> china = jedis.zrange("china", 0, -1);
        System.out.println(china);
    }

    @Test
    public void demo6() {
        List<String> list = Arrays.asList("Java", "Python", "Ruby", "JavaScript");
//        User user = new User("吖",1);
        List<User> users = new ArrayList<>();
        users.add(new User("A", 1));
        users.add(new User("B", 2));
        for (User user : users) {
            user.setAge(6);
        }
        UserArray userArray = new UserArray(users);
        System.out.println(userArray.toString());
    }

    @Test
    public void demo7() {
        String i = null;
        if (i.equals("1")) {
            System.out.println(i);
        }
    }
}