package sourcecode.spring.service.singleton.test;

import sourcecode.spring.service.singleton.lazy.LazyOne;
import sourcecode.spring.service.singleton.lazy.LazyThree;

import java.lang.reflect.Constructor;
import java.util.concurrent.CountDownLatch;

public class LazyTest {
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
                        Object obj = LazyOne.getInstance();
                        //Object obj = LazyTwo.getInstance();
                        //Object obj = LazyThree.getInstance();
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


        //内部类侵犯
//        try{
//            Class<?> clazz = LazyThree.class;
//            Constructor[] cs = clazz.getConstructors();
//            for (Constructor c:cs) {
//                //用反射强制访问
//                c.setAccessible(true);
//                Object o = c.newInstance();
//            }
//         }catch(Exception ex) {
//
//        }
        return  result;
    }

    public static void lazyThreeTest() {

        try{

            //很无聊的情况下，进行破坏
            Class<?> clazz = LazyThree.class;


            //通过反射拿到私有的构造方法
            Constructor c = clazz.getDeclaredConstructor(null);
            //强制访问，强吻，不愿意也要吻
            c.setAccessible(true);

            //暴力初始化
            Object o1 = c.newInstance();


            //调用了两次构造方法，相当于new了两次
            //犯了原则性问题，
            Object o2 = c.newInstance();

            System.out.println(o1 == o2);
//            Object o2 = c.newInstance();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
