package com.hook.record_transection;

import java.util.HashMap;
import java.util.Map;

public class GlobalFunction {

    public static Map<String,Object> getResponeBody(String msg,Object data){
        Map<String,Object> response=new HashMap<>();
        response.put("message", msg);
        response.put("body", data);
        return response;
    }
    
}