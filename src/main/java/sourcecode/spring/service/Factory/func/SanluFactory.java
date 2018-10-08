package sourcecode.spring.service.Factory.func;

import sourcecode.spring.service.Factory.Milk;
import sourcecode.spring.service.Factory.Sanlu;

/**
 * Created by Tom on 2018/3/4.
 */
public class SanluFactory implements  Factory {
    @Override
    public Milk getMilk() {
        return new Sanlu();
    }
}
