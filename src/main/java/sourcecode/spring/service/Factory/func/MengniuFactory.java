package sourcecode.spring.service.Factory.func;

import sourcecode.spring.service.Factory.Mengniu;
import sourcecode.spring.service.Factory.Milk;

/**
 * Created by Tom on 2018/3/4.
 */
public class MengniuFactory implements  Factory {


    @Override
    public Milk getMilk() {
        return new Mengniu();
    }
}
