/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benny.utilities;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Benny~
 */
public class Region {
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
    
    
}
