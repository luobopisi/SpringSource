package sourcecode.spring.service.singleton.seriable;

import java.io.Serializable;

/**
 * Created by Tom on 2018/3/7.
 */

//反序列化时导致单例破坏
public class Seriable implements Serializable {


    //序列化就是说把内存中的状态通过转换成字节码的形式
    //从而转换一个IO流，写入到其他地方(可以是磁盘、网络IO)
    //内存中状态给永久保存下来了

    //反序列化
    //讲已经持久化的字节码内容，转换为IO流
    //通过IO流的读取，进而将读取的内容转换为Java对象
    //在转换过程中会重新创建对象new


    public  final static Seriable INSTANCE = new Seriable();
    private Seriable(){}

    public static  Seriable getInstance(){
        return INSTANCE;
    }
    //为了实现序列化之后对象重复调用，需重写该方法，该方法有jvm自动调用（不重写该方法时，序列化之后该类不是单例）
    private  Object readResolve(){
        return  INSTANCE;
    }

}
