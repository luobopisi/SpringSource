package sourcecode.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sourcecode.spring.base.ResponseDefine;
import sourcecode.spring.service.delegate.leader.Boss;
import sourcecode.spring.service.template.MemberDaoTest;
import sourcecode.spring.utils.ResUtil;

import javax.servlet.http.HttpServletRequest;

//委派模式
@RestController
@RequestMapping(value ="delegate")
public class DelegateController {


    @RequestMapping(value = "/boss")
    public String boss(HttpServletRequest req)throws Exception {
        try {
            Boss.test();

            return ResUtil.convert(ResponseDefine.Success, "success", 0);
        }catch (Exception e){
            e.printStackTrace();
            return ResUtil.convert(ResponseDefine.Exception, "wxcard正在休息，请稍后再试", 0);
        }
    }
}
