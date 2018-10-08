package sourcecode.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sourcecode.spring.base.ResponseDefine;
import sourcecode.spring.service.singleton.test.HungryTest;
import sourcecode.spring.service.singleton.test.LazyTest;
import sourcecode.spring.service.singleton.test.RegisterTest;
import sourcecode.spring.utils.ResUtil;

import javax.servlet.http.HttpServletRequest;

//工厂模式
@RestController
@RequestMapping(value ="singleton")
public class SingletonController {

    /**
     * 饿汉时单例
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/hungry")
    public String hungry(HttpServletRequest req)throws Exception {
        try {
            String result = HungryTest.test();
            return ResUtil.convert(ResponseDefine.Success, "success", result);
        }catch (Exception e){
            e.printStackTrace();
            return ResUtil.convert(ResponseDefine.Exception, "wxcard正在休息，请稍后再试", 0);
        }
    }

    @RequestMapping(value = "/lazy")
    public String lazy(HttpServletRequest req)throws Exception {
        try {
            String result = LazyTest.test();
            return ResUtil.convert(ResponseDefine.Success, "success", result);
        }catch (Exception e){
            e.printStackTrace();
            return ResUtil.convert(ResponseDefine.Exception, "wxcard正在休息，请稍后再试", 0);
        }
    }

    @RequestMapping(value = "/register")
    public String register(HttpServletRequest req)throws Exception {
        try {
            String result = RegisterTest.test();
            String result2 = RegisterTest.test2();
            return ResUtil.convert(ResponseDefine.Success, "success", result);
        }catch (Exception e){
            e.printStackTrace();
            return ResUtil.convert(ResponseDefine.Exception, "wxcard正在休息，请稍后再试", 0);
        }
    }
}
