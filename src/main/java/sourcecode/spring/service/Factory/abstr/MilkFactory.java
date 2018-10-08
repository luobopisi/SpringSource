package sourcecode.spring.service.Factory.abstr;

import org.springframework.stereotype.Service;
import sourcecode.spring.service.Factory.*;

/**
 * Created by Tom on 2018/3/4.
 */
@Service
public class MilkFactory extends  AbstractFactory {


    @Override
    public Milk getMengniu() {
        return new Mengniu();
    }

    @Override
    public Milk getYili() {
        return new Yili();
    }

    @Override
    public Milk getTelunsu() {
        return new Telunsu();
    }

    @Override
    public Milk getSanlu() {
        return new Sanlu();
    }
}
