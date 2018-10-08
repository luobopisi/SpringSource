package sourcecode.spring.service.proxy.staticed;

//静态代理
public class StaticProxyTest {

    public static void test() {

        //只能帮儿子找对象
        //不能帮表妹、不能帮陌生人
        Father father = new Father(new Son());

        father.findLove();

    }
}
