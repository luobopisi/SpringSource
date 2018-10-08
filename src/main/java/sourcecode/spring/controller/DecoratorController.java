package sourcecode.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sourcecode.spring.base.ResponseDefine;
import sourcecode.spring.service.decorator.passport.SigginTest;
import sourcecode.spring.utils.ResUtil;

import javax.servlet.http.HttpServletRequest;

//装饰者模式
@RestController
@RequestMapping(value ="decorator")
public class DecoratorController {


    @RequestMapping(value = "/test")
    public String test(HttpServletRequest req)throws Exception {
        try {
            SigginTest.test();

            return ResUtil.convert(ResponseDefine.Success, "success", 0);
        }catch (Exception e){
            e.printStackTrace();
            return ResUtil.convert(ResponseDefine.Exception, "wxcard正在休息，请稍后再试", 0);
        }
    }
}
