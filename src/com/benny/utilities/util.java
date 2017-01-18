/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benny.utilities;

import com.qcloud.Utilities.Json.JSONObject;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Benny~
 */
public class util {
    private Map region=new HashMap();
    
    
    /**
     * 节点中文转英文
     * @param text
     * @return String
     */
    public String getRegion(String text)
    {
        region.put("广州","gz");
        region.put("上海","sh");
        region.put("北京","bj");
        region.put("香港","hk");
        region.put("新加坡","sg");
        region.put("北美","ca");
        return region.get(text).toString();
    
    }
    
    /**
     * 根据key、loc，返回API结果中的指定值
     * @param obj
     *              A JSONObject
     * @param loc
     *              Numbers of your instance, start from 0
     * @param key 
     *              Specified key
     * @return selected value
     */
    public String getIV(JSONObject obj,int loc,String key){
    
        return obj.getJSONArray("instanceSet").getJSONObject(loc).get(key).toString();
      
    
  
    
    
    }
    
    
}
