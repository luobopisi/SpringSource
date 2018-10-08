package sourcecode.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sourcecode.spring.base.ResponseDefine;
import sourcecode.spring.service.proxy.cglib.CglibTest;
import sourcecode.spring.service.proxy.jdk.JDKProxyTest;
import sourcecode.spring.service.proxy.staticed.StaticProxyTest;
import sourcecode.spring.utils.ResUtil;

import javax.servlet.http.HttpServletRequest;

//代理模式
@RestController
@RequestMapping(value ="proxy")
public class ProxyController {

    //静态代理
    @RequestMapping(value = "/staticProxy")
    public String staticProxy(HttpServletRequest req)throws Exception {
        try {
            StaticProxyTest.test();
            return ResUtil.convert(ResponseDefine.Success, "success", 0);
        }catch (Exception e){
            e.printStackTrace();
            return ResUtil.convert(ResponseDefine.Exception, "wxcard正在休息，请稍后再试", 0);
        }
    }

    //JKD动态代理
    @RequestMapping(value = "/jdkProxy")
    public String jdkProxy(HttpServletRequest req)throws Exception {
        try {
            //JDKProxyTest.test();
            JDKProxyTest.test2();
            return ResUtil.convert(ResponseDefine.Success, "success", 0);
        }catch (Exception e){
            e.printStackTrace();
            return ResUtil.convert(ResponseDefine.Exception, "wxcard正在休息，请稍后再试", 0);
        }
    }
    //cglib动态代理
    @RequestMapping(value = "/cglibProxy")
    public String cglibProxy(HttpServletRequest req)throws Exception {
        try {

            CglibTest.test();
            return ResUtil.convert(ResponseDefine.Success, "success", 0);
        }catch (Exception e){
            e.printStackTrace();
            return ResUtil.convert(ResponseDefine.Exception, "wxcard正在休息，请稍后再试", 0);
        }
    }
}
