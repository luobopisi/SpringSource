package sourcecode.spring.service.singleton.test;


import sourcecode.spring.service.singleton.register.Color;
import sourcecode.spring.service.singleton.register.RegisterMap;
import sourcecode.spring.service.singleton.register.RegiterEnum;

import java.util.concurrent.CountDownLatch;

public class RegisterTest {
    public static String test() {
        String result=null;
        int count = 200;

        //发令枪，我就能想到运动员
        CountDownLatch latch = new CountDownLatch(count);

        long start = System.currentTimeMillis();
        for (int i = 0; i < count;i ++) {
            new Thread(){
                @Override
                public void run() {
                    try{

                        try {
                            // 阻塞
                            // count = 0 就会释放所有的共享锁
                            // 万箭齐发
                            latch.await();
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        //必然会调用，可能会有很多线程同时去访问getInstance()
                        Object obj = RegisterMap.getInstance("RegisterMap");
                        System.out.println(System.currentTimeMillis() + ":" + obj);

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }.start(); //每循环一次，就启动一个线程,具有一定的随机性

            //每次启动一个线程，count --
            latch.countDown();

        }
        long end = System.currentTimeMillis();
        result ="总耗时：" + (end - start);
        return  result;
    }

    public static String test2() {
        String result=null;
        int count = 200;

        //发令枪，我就能想到运动员
        CountDownLatch latch = new CountDownLatch(count);

        long start = System.currentTimeMillis();
        for (int i = 0; i < count;i ++) {
            new Thread(){
                @Override
                public void run() {
                    try{

                        try {
                            // 阻塞
                            // count = 0 就会释放所有的共享锁
                            // 万箭齐发
                            latch.await();
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        //必然会调用，可能会有很多线程同时去访问getInstance()
                        Object obj = RegiterEnum.BLACK;
                        System.out.println(System.currentTimeMillis() + ":" + obj);

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }.start(); //每循环一次，就启动一个线程,具有一定的随机性

            //每次启动一个线程，count --
            latch.countDown();

        }
        long end = System.currentTimeMillis();
        result ="总耗时：" + (end - start);
        return  result;
    }
    //枚举式注册
    public static void test3() {
        System.out.println(Color.RED);
    }
}
