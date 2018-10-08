package sourcecode.spring.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.ValueFilter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ResUtil {
    private static ValueFilter filter = new ValueFilter() {
        @Override
        public Object process(Object obj, String s, Object v) {
            if (v == null)
                return "";
            return v;
        }
    };
    public static String convert( String res_code, String res_msg,Object obj) {
        JSONObject json = new JSONObject();
        try
        {
            json.put("code", res_code);
            json.put("msg", res_msg);
            if (obj instanceof Map) {
                json.put("info", obj == null ? new HashMap() : obj);
            } else if (obj instanceof List) {
                List list = (List) obj;
                json.put("info", list == null ? new ArrayList() : list);
            } else if (obj instanceof String) {
                json.put("info", obj);
            } else {
                json.put("info", obj);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(json,filter);
    }
}
