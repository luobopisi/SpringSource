package sourcecode.spring.service.Factory.func;


import sourcecode.spring.service.Factory.Milk;

/**
 * 工厂模型
 * Created by Tom on 2018/3/4.
 */
public interface Factory {

    //工厂必然具有生产产品技能，统一的产品出口
    Milk getMilk();

}
