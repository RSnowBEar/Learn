package com.RSnowBEar.util;

import com.RSnowBEar.dao.impl.productDaoImpl;
import com.RSnowBEar.dao.productDao;
import com.RSnowBEar.entity.Productspecificationdic;
import com.RSnowBEar.entity.Productspecificationvalues;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class skuUtil {
    static productDao pd = new productDaoImpl();
    public static Map<String,String> getSkuMap(String skuAttribute){
        Map<String,String> map = new HashMap<>();

        String[] attributes = skuAttribute.substring(1, skuAttribute.length() - 1).split(",");
        for (String attribute : attributes) {
            String[] specifications = attribute.split(":");
            map.put(pd.selectProductspecificationdicByID(specifications[0]).get(0).getSpecificationDicName(),
                    pd.selectProductspecificationvaluesByID(specifications[1]).get(0).getSpecificationName());
        }
        return map;
    }

    public static String getSkuString(Map<String,String> map,Long categoryID){
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            String value = map.get(key);
            Productspecificationdic p = new Productspecificationdic(key, categoryID);
            List<Productspecificationdic> ps = pd.selectProductspecificationdicByID(p);
            Productspecificationdic pp = ps.get(0);
            Long sID = pp.getSpecificationDicId();
            long specificationId = pd.selectProductspecificationvaluesBySIDAndName(new Productspecificationvalues(sID, value)).get(0).getSpecificationId();
            sb.append(sID+":"+specificationId);
            sb.append(",");
        }
        String substring = sb.substring(0, sb.length() - 1);
        substring += "}";
        return substring;
    }
}
