package sourcecode.spring.service.proxy.cglib;

/**
 * Created by Tom on 2018/3/10.
 */
public class CglibTest {

    public static void test() {

        try {
            ZhangSan obj = (ZhangSan)new CglibMeipo().getInstance(ZhangSan.class);
            obj.findLove();
            System.out.println("--------------------------------");
           // System.out.println(obj.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
