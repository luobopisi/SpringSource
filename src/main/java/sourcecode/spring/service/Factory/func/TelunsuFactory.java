package sourcecode.spring.service.Factory.func;

import sourcecode.spring.service.Factory.Milk;
import sourcecode.spring.service.Factory.Telunsu;

/**
 * 事情变得越来越专业
 * Created by Tom on 2018/3/4.
 */
public class TelunsuFactory implements Factory {

    @Override
    public Milk getMilk() {
        return new Telunsu();
    }
}
