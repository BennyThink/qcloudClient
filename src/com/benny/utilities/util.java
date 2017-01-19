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
    //定义一些可能会用到的变量
    private Map customMap=new HashMap();
    String instanceID;
    String diskID;
   JSONObject diskInfo=new JSONObject();
    /**
     * 节点中文转英文
     * @param text
     * @return String
     */
    public String getRegion(String text)
    {   customMap.clear();
        customMap.put("广州","gz");
        customMap.put("上海","sh");
        customMap.put("北京","bj");
        customMap.put("香港","hk");
        customMap.put("新加坡","sg");
        customMap.put("北美","ca");
        return customMap.get(text).toString();
    
    }
    /**
     * 转换数字参数为运行状态
     * @param statusNum
     *          代表运行状态的数字
     * @return 
     *          运行状态
     */
    public String convertStatus(String statusNum) {
        customMap.clear();
        //put status
        customMap.put("1", "鼓掌");
        customMap.put("2", "运行中");
        customMap.put("3", "创建中");
        customMap.put("4", "已关机");
        customMap.put("5", "已退还");
        customMap.put("6", "退还中");
        customMap.put("7", "重启中");
        customMap.put("8", "开机中");
        customMap.put("9", "关机中");
        customMap.put("10", "密码重置中");
        customMap.put("11", "格式化中");
        customMap.put("12", "镜像制作中");
        customMap.put("13", "带宽设置中");
        customMap.put("14", "重装系统中");
        customMap.put("15", "域名邦定中");
        customMap.put("16", "域名解绑中");
        customMap.put("17", "负载均衡绑定中");
        customMap.put("18", "负载均衡解绑中");
        customMap.put("19", "升级中");
        customMap.put("20", "密钥下发中");
        customMap.put("21", "维护中");
        //put ends
        return customMap.get(statusNum).toString();
        
    }
    
    
    /**
     * 转换数字参数为硬盘类型
     * @param diskInf
     * @return 
     *          硬盘类型
     */
    public String convertStatus(Object diskInf) 
    {   //
        customMap.clear();
        customMap.put("1", "本地盘");
        customMap.put("2", "云硬盘");
        customMap.put("3", "SSD本地盘");
        customMap.put("4", "SSD云盘");
        return customMap.get("2").toString();
       
     
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
        //实例ID和硬盘ID
        //System.out.println(obj.getJSONArray("instanceSet").getJSONObject(loc).get("unInstanceId").toString());
        
        if("status".equals(key))    
            return convertStatus(obj.getJSONArray("instanceSet").getJSONObject(loc).get(key).toString());          
        else if("diskInfo".equals(key)) //硬盘 
        {   diskInfo=(JSONObject)obj.getJSONArray("instanceSet").getJSONObject(loc).get("diskInfo");
        return convertStatus(diskInfo.get("rootType"))+diskInfo.get("rootSize")+"G";     
        }
        else
        return obj.getJSONArray("instanceSet").getJSONObject(loc).get(key).toString();
      
    
  
    
    
    }
    
    
}
