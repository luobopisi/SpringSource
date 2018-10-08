package sourcecode.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sourcecode.spring.base.ResponseDefine;
import sourcecode.spring.service.Factory.Milk;
import sourcecode.spring.service.Factory.abstr.AbstractFactory;
import sourcecode.spring.service.Factory.abstr.MilkFactory;
import sourcecode.spring.service.Factory.func.Factory;
import sourcecode.spring.service.Factory.func.SanluFactory;
import sourcecode.spring.service.Factory.simple.SimpleFactory;
import sourcecode.spring.utils.ResUtil;

import javax.servlet.http.HttpServletRequest;
//工厂模式
@RestController
@RequestMapping(value ="factory")
public class FactoryController {




    /**
     * 简单工厂模式
     * @param name
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/simpleFactory")
    public String simpleFactory(@RequestParam("name") String name,HttpServletRequest req)throws Exception {
        try {
            Milk milk = SimpleFactory.getMilk(name);
            if(milk ==null)
            {
                return ResUtil.convert(ResponseDefine.Fail, "无此品牌牛奶", null);
            }
            return ResUtil.convert(ResponseDefine.Success, "success", milk.getName());
        }catch (Exception e){
            e.printStackTrace();
            return ResUtil.convert(ResponseDefine.Exception, "wxcard正在休息，请稍后再试", 0);
        }
    }


    @RequestMapping(value = "/abstractFactory")
    public String abstractFactory(HttpServletRequest req)throws Exception {
        try {
            AbstractFactory factory = new MilkFactory();
            Milk sanluMilk= factory.getSanlu();

            return ResUtil.convert(ResponseDefine.Success, "success", sanluMilk.getName());
        }catch (Exception e){
            e.printStackTrace();
            return ResUtil.convert(ResponseDefine.Exception, "wxcard正在休息，请稍后再试", 0);
        }
    }

    @RequestMapping(value = "/funFactory")
    public String funFactory(HttpServletRequest req)throws Exception {
        try {
            Factory factory = new SanluFactory();
            Milk sanluMilk= factory.getMilk();

            return ResUtil.convert(ResponseDefine.Success, "success", sanluMilk.getName());
        }catch (Exception e){
            e.printStackTrace();
            return ResUtil.convert(ResponseDefine.Exception, "wxcard正在休息，请稍后再试", 0);
        }
    }
}
