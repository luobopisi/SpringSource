package sourcecode.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sourcecode.spring.base.ResponseDefine;
import sourcecode.spring.service.strategy.PayStrategyTest;
import sourcecode.spring.utils.ResUtil;

import javax.servlet.http.HttpServletRequest;

//策略模式
@RestController
@RequestMapping(value ="Strategy")
public class StrategyController {
    @RequestMapping(value = "/hungry")
    public String hungry(HttpServletRequest req)throws Exception {
        try {
            PayStrategyTest.test();
            return ResUtil.convert(ResponseDefine.Success, "success", 0);
        }catch (Exception e){
            e.printStackTrace();
            return ResUtil.convert(ResponseDefine.Exception, "wxcard正在休息，请稍后再试", 0);
        }
    }
}
