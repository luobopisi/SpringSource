package sourcecode.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sourcecode.spring.base.ResponseDefine;
import sourcecode.spring.service.observer.subject.ObserverTest;
import sourcecode.spring.utils.ResUtil;

import javax.servlet.http.HttpServletRequest;

//观察者模式
@RestController
@RequestMapping(value ="observer")
public class ObserverController {


    @RequestMapping(value = "/observerLily")
    public String observerLily(HttpServletRequest req)throws Exception {
        try {
            ObserverTest.test();

            return ResUtil.convert(ResponseDefine.Success, "success", 0);
        }catch (Exception e){
            e.printStackTrace();
            return ResUtil.convert(ResponseDefine.Exception, "wxcard正在休息，请稍后再试", 0);
        }
    }
}
