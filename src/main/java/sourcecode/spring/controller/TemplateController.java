package sourcecode.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sourcecode.spring.base.ResponseDefine;
import sourcecode.spring.service.template.MemberDaoTest;
import sourcecode.spring.utils.ResUtil;

import javax.servlet.http.HttpServletRequest;

//模板模式
@RestController
@RequestMapping(value ="template")
public class TemplateController {

    /**
     * 简单工厂模式
     * @param
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/simpleFactory")
    public String simpleFactory(HttpServletRequest req)throws Exception {
        try {
            MemberDaoTest.test();

            return ResUtil.convert(ResponseDefine.Success, "success", 0);
        }catch (Exception e){
            e.printStackTrace();
            return ResUtil.convert(ResponseDefine.Exception, "wxcard正在休息，请稍后再试", 0);
        }
    }
}
