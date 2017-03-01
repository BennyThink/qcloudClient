/*
 * Copyright (C) 2017 Benny~
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package com.benny.utilities;

import com.qcloud.Module.Cvm;
import com.qcloud.Module.Snapshot;
import com.qcloud.QcloudApiModuleCenter;
import com.qcloud.Utilities.Json.JSONObject;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.mozilla.intl.chardet.nsDetector;
import org.mozilla.intl.chardet.nsICharsetDetectionObserver;

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
    private boolean found = false;
    private String encoding = null;
    
   
  
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
     * 取得镜像对应的ID
     * @param ImageName
     *          镜像名字
     * @return 
     *          ImageID
     */
    public String getImageID(String ImageName){
        customMap.clear();
        customMap.put("当前系统", "current");
        customMap.put("CentOS 6.7 32位", "img-ljriodz5");
        customMap.put("CentOS 6.7 64位", "img-9iwld2rx");
        customMap.put("CentOS 7.2 64位", "img-31tjrtph");
        customMap.put("Debian 8.2 32位", "img-ez7jwngr");
        customMap.put("Debian 8.2 64位", "img-hi93l4ht");
        customMap.put("Debian 7.8 32位", "img-2p1g2wjv");
        customMap.put("Debian 7.8 64位", "img-feqctcrx");
        customMap.put("openSUSE 13.2 64位", "img-pmhtrjdx");
        customMap.put("FreeBSD 10.1 64位", "img-871lthrb");
        customMap.put("CoreOS 717.3.0 64位", "img-6mre94jv");
        customMap.put("Ubuntu Server 14.04.1 LTS 32位", "img-qpxvpujt");
        customMap.put("Ubuntu Server 14.04.1 LTS 64位", "img-3wnd9xpl");
        customMap.put("Ubuntu Server 16.04.1 LTS 32位", "img-8u6dn6p1");
        customMap.put("Ubuntu Server 16.04.1 LTS 64位", "img-pyqx34y1");
        customMap.put("Windows Server 2012 R2 标准版 64位中文版", "img-egif9bvl");
        customMap.put("Windows Server 2012 R2 数据中心版 64位中文版", "img-29hl923v");
        customMap.put("Windows Server 2008 R2 企业版 SP1 64位", "img-0vbqvzfn");
        
        return customMap.get(ImageName).toString();
   
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
        return uDiskID+"·"+convertStatus(uDiskInfo.get("rootType"))+uDiskInfo.get("rootSize")+"G";     
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
        { params.put("limits", 3);
         params.put("storageIds.0", diskID);
        }
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
    

    public String resetOS(Map uAuth,String region,String Instance,String password,String imageId){    
        
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
       
        if (imageId == "current") {
            params.put("instanceId", Instance);
            params.put("password", password);
        } else {
            params.put("instanceId", Instance);
            params.put("imageType", 2);
            params.put("imageId", imageId);
            params.put("password", password);
        }
       
        /* generateUrl 方法生成请求串，但不发送请求。在正式请求中，可以删除下面这行代码。 */
        //System.out.println(module.generateUrl("ResetInstances",params));
		String result = null;
		try {
			/* call 方法正式向指定的接口名发送请求，并把请求参数params传入，返回即是接口的请求结果。 */
			result = module.call("ResetInstances", params);
			json_result = new JSONObject(result);
			//System.out.println(json_result);//原始响应，需要将其处理      
            
		} catch (Exception e) {
			System.out.println("error..." + e.getMessage());
		}
            //return null;
           return json_result.getString("codeDesc")+json_result.getString("message");
     
    }
    
    
    public String guessFileEncoding(File file) throws FileNotFoundException, IOException {
        return guessFileEncoding(file, new nsDetector());
    }

    /**
     * <pre>
     * 获取文件的编码
     * @param file
     *            File对象实例
     * @param languageHint 语言提示区域代码 @see #nsPSMDetector ,取值如下： 1 : Japanese 2 : Chinese 3 : Simplified Chinese 4 : Traditional Chinese 5 :
     * Korean 6 : Dont know(default)
     * </pre>
     *
     * @return 文件编码，eg：UTF-8,GBK,GB2312形式(不确定的时候，返回可能的字符编码序列)；若无，则返回null
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String guessFileEncoding(File file, int languageHint) throws FileNotFoundException, IOException {
        return guessFileEncoding(file, new nsDetector(languageHint));
    }

    /**
     * 获取文件的编码
     *
     * @param file
     * @param det
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    private String guessFileEncoding(File file, nsDetector det) throws FileNotFoundException, IOException {
        // Set an observer...
        // The Notify() will be called when a matching charset is found.
        det.Init(new nsICharsetDetectionObserver() {
            public void Notify(String charset) {
                encoding = charset;
                found = true;
            }
        });

        BufferedInputStream imp = new BufferedInputStream(new FileInputStream(file));
        byte[] buf = new byte[1024];
        int len;
        boolean done = false;
        boolean isAscii = false;

        while ((len = imp.read(buf, 0, buf.length)) != -1) {
            // Check if the stream is only ascii.
            isAscii = det.isAscii(buf, len);
            if (isAscii) {
                break;
            }
            // DoIt if non-ascii and not done yet.
            done = det.DoIt(buf, len, false);
            if (done) {
                break;
            }
        }
        imp.close();
        det.DataEnd();

        if (isAscii) {
            encoding = "ASCII";
            found = true;
        }

        if (!found) {
            String[] prob = det.getProbableCharsets();
            //这里将可能的字符集组合起来返回
            for (int i = 0; i < prob.length; i++) {
                if (i == 0) {
                    encoding = prob[i];
                } else {
                    encoding += "," + prob[i];
                }
            }

            if (prob.length > 0) {
                // 在没有发现情况下,也可以只取第一个可能的编码,这里返回的是一个可能的序列
                return encoding;
            } else {
                return null;
            }
        }
        return encoding;
    }
    
    
    
    
}
