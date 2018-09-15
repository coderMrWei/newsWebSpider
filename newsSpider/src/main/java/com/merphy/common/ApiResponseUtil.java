package com.merphy.common;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author yibaowei on 9/15/18.
 */
public class ApiResponseUtil {

    public static Map<String,Object> genDataResponse(Object data){
        Map<String,Object> result = Maps.newHashMap();
        result.put("ret",true);
        result.put("errCode",0);
        result.put("errMsg","");
        result.put("data",data);
        return result;
    }

    public static Map<String,Object> genErrResponse(String errMsg,Integer errCode){
        Map<String,Object> result = Maps.newHashMap();
        result.put("ret",true);
        result.put("errCode",errCode);
        result.put("errMsg",errMsg);
        result.put("data",null);
        return result;
    }

}
