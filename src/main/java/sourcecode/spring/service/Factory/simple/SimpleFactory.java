package sourcecode.spring.service.Factory.simple;

import sourcecode.spring.service.Factory.Mengniu;
import sourcecode.spring.service.Factory.Milk;
import sourcecode.spring.service.Factory.Telunsu;
import sourcecode.spring.service.Factory.Yili;

/**
 * Created by Tom on 2018/3/4.
 */
public class SimpleFactory {

    public static Milk  getMilk(String name){
        if("特仑苏".equals(name)){
            return new Telunsu();
        }else if("伊利".equals(name)){
            return new Yili();
        }else if("蒙牛".equals(name)){
            return new Mengniu();
        }else {
            System.out.println("不能生产您所需的产品");
            return null;
        }
    }

}
