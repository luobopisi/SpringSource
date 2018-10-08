package sourcecode.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sourcecode.spring.base.ResponseDefine;
import sourcecode.spring.service.prototype.deep.DeepClone;
import sourcecode.spring.service.prototype.simple.CloneTest;
import sourcecode.spring.utils.ResUtil;

import javax.servlet.http.HttpServletRequest;
//原型模式
@RestController
@RequestMapping(value ="prototype")
public class PrototypeController {


    @RequestMapping(value = "/simple")
    public String simple( HttpServletRequest req)throws Exception {
        try {
            CloneTest.test();

            return ResUtil.convert(ResponseDefine.Success, "success", 0);
        }catch (Exception e){
            e.printStackTrace();
            return ResUtil.convert(ResponseDefine.Exception, "wxcard正在休息，请稍后再试", 0);
        }
    }

    @RequestMapping(value = "/deep")
    public String deep( HttpServletRequest req)throws Exception {
        try {
            DeepClone.test();

            return ResUtil.convert(ResponseDefine.Success, "success", 0);
        }catch (Exception e){
            e.printStackTrace();
            return ResUtil.convert(ResponseDefine.Exception, "wxcard正在休息，请稍后再试", 0);
        }
    }
}
