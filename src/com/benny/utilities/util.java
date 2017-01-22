/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benny.utilities;

import com.qcloud.Module.Cvm;
import com.qcloud.Module.Snapshot;
import com.qcloud.QcloudApiModuleCenter;
import com.qcloud.Utilities.Json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Benny~
 */
public class util {
    //定义一些可能会用到的变量
    private final Map customMap=new HashMap();
    public String uDiskID;
    private JSONObject uDiskInfo=new JSONObject();
    public JSONObject json_result=new JSONObject();
    
   
  
    /**
     * 转换数字参数为运行状态
     * @param statusNum
     *          代表运行状态的数字
     * @return 
     *          运行状态字符串
     */
    public String convertStatus(String statusNum) {
        customMap.clear();
        //put status
        customMap.put("1", "故障");
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
     *              实例数量，从0开始计数
     * @param key 
     *              特定键
     * @return 指定值
     */
    public String getIV(JSONObject obj,int loc,String key){
        //实例ID和硬盘ID
        uDiskInfo=(JSONObject)obj.getJSONArray("instanceSet").getJSONObject(loc).get("diskInfo");
        uDiskID=uDiskInfo.get("rootId").toString();
        
        if("status".equals(key))    
            return convertStatus(obj.getJSONArray("instanceSet").getJSONObject(loc).get(key).toString());          
        else if("diskInfo".equals(key)) //硬盘 
        {   uDiskInfo=(JSONObject)obj.getJSONArray("instanceSet").getJSONObject(loc).get("diskInfo");
        return convertStatus(uDiskInfo.get("rootType"))+uDiskInfo.get("rootSize")+"G";     
        }
        else
        return obj.getJSONArray("instanceSet").getJSONObject(loc).get(key).toString();
        
    
    }
    
    
    public String getSV(JSONObject obj,int loc,String key){
        //实例ID和硬盘ID
        String str=obj.getJSONArray("snapshotSet").getJSONObject(loc).get(key).toString();
        
        if("snapshotName".equals(key) &&"".equals(str) )
            return "未命名";       
        else if("snapshotStatus".equals(key)&&"normal".equals(str))
            return "已创建";       
        else if("snapshotStatus".equals(key)&&"creating".equals(str))
            return "创建中";
        else if("snapshotStatus".equals(key)&&"rollbacking".equals(str))
            return "回滚中";
        else
            return obj.getJSONArray("snapshotSet").getJSONObject(loc).get(key).toString();
        
    
    }
    
    
    
    
    
    
    /**
     * 
     * @param uAuth
     *              secretID和secretKey
     * @param region
     *              地区，北京，上海，广州...
     * @param instanceID
     *              实例ID，可传递null
     * @param Action
     *              要进行的操作，RestartInstances
     * @return 从API返回的查询结果
     */
    public JSONObject doInstance(Map uAuth,String region,String instanceID,String Action){    
        //首先转换region为简写 public void doInstance(Map uAuth,String region,String instanceID,String Action)
        if(region=="广州")
            region="gz";
        else if(region=="上海")
            region="sh";
        else if(region=="北京")
            region="bj";
        else if(region=="香港")
            region="hk";
        else if(region=="新加坡")
            region="sg";
        else if(region=="北美")
            region="ca";
                   
		TreeMap<String, Object> config = new TreeMap<String, Object>();
		config.put("SecretId", uAuth.get("secretId"));
		config.put("SecretKey", uAuth.get("secretKey"));
		config.put("RequestMethod", "GET");
		config.put("DefaultRegion", region);
		QcloudApiModuleCenter module = new QcloudApiModuleCenter(new Cvm(),
				config);
		TreeMap<String, Object> params = new TreeMap<String, Object>();//instanceIds.0
        if(instanceID==null)
        {params.put("offset", 0);
        params.put("limit", 3);}
        else
            params.put("instanceIds.0", instanceID);//可能有坑
	    
        /* generateUrl 方法生成请求串，但不发送请求。在正式请求中，可以删除下面这行代码。 */
        //System.out.println(module.generateUrl(Action, params));
		String result = null;
		try {
			/* call 方法正式向指定的接口名发送请求，并把请求参数params传入，返回即是接口的请求结果。 */
			result = module.call(Action, params);//RestartInstances
			json_result = new JSONObject(result);
			//System.out.println(json_result);//原始响应，需要将其处理      
           
		} catch (Exception e) {
			System.out.println("error..." + e.getMessage());
		}

            return json_result;
     
    }
    
    /**
     * 
     * @param uAuth
     *              id、key
     * @param region
     *              地区，广州，可为null
     * @param diskID
     *              磁盘ID
     * @param Action
     *              执行的操作, i.e.DescribeSnapshots
     * @param Name  
     *              快照ID
     * @return 
     */
    
    public JSONObject doSnapshot(Map uAuth,String region,String diskID,String Action,String Name){    
        //
        if(region=="广州")
            region="gz";
        else if(region=="上海")
            region="sh";
        else if(region=="北京")
            region="bj";
        else if(region=="香港")
            region="hk";
        else if(region=="新加坡")
            region="sg";
        else if(region=="北美")
            region="ca";
                   
		TreeMap<String, Object> config = new TreeMap<String, Object>();
		config.put("SecretId", uAuth.get("secretId"));
		config.put("SecretKey", uAuth.get("secretKey"));
		config.put("RequestMethod", "GET");
		config.put("DefaultRegion", region);
		QcloudApiModuleCenter module = new QcloudApiModuleCenter(new Snapshot(),
				config);
		TreeMap<String, Object> params = new TreeMap<String, Object>();//instanceIds.0
        if(Action=="DescribeSnapshots")
            params.put("limits", 3);
        if(Action=="DeleteSnapshot")
            params.put("snapshotIds.0", diskID);
        
        if(Action=="ApplySnapshot")//两参数
        {params.put("storageId", diskID);
        params.put("snapshotId", Name);
        System.out.println("已调用还原 "+params);
        }
        
        if(Name==null && Action=="CreateSnapshot")
            params.put("storageId", diskID);
        
       if(Name!=null && Action=="CreateSnapshot")
       {params.put("storageId", diskID);
        params.put("snapshotName", Name);    }
       
        /* generateUrl 方法生成请求串，但不发送请求。在正式请求中，可以删除下面这行代码。 */
       //System.out.println(module.generateUrl(Action,params));
		String result = null;
		try {
			/* call 方法正式向指定的接口名发送请求，并把请求参数params传入，返回即是接口的请求结果。 */
			result = module.call(Action, params);//RestartInstances
			json_result = new JSONObject(result);
			//System.out.println(json_result);//原始响应，需要将其处理      
            
		} catch (Exception e) {
			System.out.println("error..." + e.getMessage());
		}

            return json_result;
     
    }
    

    
}
