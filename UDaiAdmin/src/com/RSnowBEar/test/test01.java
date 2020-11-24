package com.RSnowBEar.test;

import com.RSnowBEar.dao.impl.productDaoImpl;
import com.RSnowBEar.dao.productDao;
import com.RSnowBEar.entity.*;
import com.RSnowBEar.util.jdbcUtil;
import com.RSnowBEar.util.skuUtil;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Timestamp;
import java.util.*;

public class test01 {

    @Test
    public void test9(){
        
    }

    @Test
    public void test8(){
        Productsku p = new Productsku();
        double price = p.getPrice();
        System.out.println(price);
    }

    @Test
    public void test7(){
        //新建商品
        Product p = new Product();
        p.setProductName("biao包3");
        p.setCategoryID(26);
        p.setShelfTime((new Timestamp(new Date().getTime())));
        p.setShelfStatus(0);

        //商品所有属性
        Productsku pSku = new Productsku();
        Map map = new HashMap();
        map.put("颜色", "奶白色");
        Long categoryID = Long.valueOf(p.getCategoryID());
        pSku.setSkuAttribute(skuUtil.getSkuString(map,categoryID));
        pSku.setPrice(100);
        pSku.setInventory(21000);

        Productsku pSku2 = new Productsku();
        Map map2 = new HashMap();
        map2.put("颜色", "黑色");
        Long categoryID2 = Long.valueOf(p.getCategoryID());
        pSku2.setSkuAttribute(skuUtil.getSkuString(map2,categoryID2));
        pSku2.setPrice(500);
        pSku2.setInventory(500);

        Productsku pSku3 = new Productsku();
        Map map3 = new HashMap();
        map3.put("颜色", "灰色");
        Long categoryID3 = Long.valueOf(p.getCategoryID());
        pSku3.setSkuAttribute(skuUtil.getSkuString(map3,categoryID3));
        pSku3.setPrice(200);
        pSku3.setInventory(200);

        List<Productsku> list = new ArrayList<>();
        list.add(pSku);
        list.add(pSku2);
        list.add(pSku3);

        for (Productsku productsku : list) {
            String skuAttribute = productsku.getSkuAttribute();
        }

        productDao pd = new productDaoImpl();
        int i = pd.insertNewProduct(p, list);
        System.out.println(i);
    }

    @Test
    public void test3(){
        productDao pd = new productDaoImpl();

        Product p = new Product();
        p.setProductName("小红花");
        p.setCategoryID(27);
        p.setShelfTime((Timestamp)new Date());
        p.setShelfStatus(0);

        Productsku ps = new Productsku();
        ps.setProductId(p.getProductId());

    }

    @Test
    public void test4(){
        Map<String,String> map = new HashMap<>();
        map.put("颜色", "红色");
        map.put("尺寸", "50L");

        productDao pd = new productDaoImpl();
        String skuString = skuUtil.getSkuString(map, 28l);
        System.out.println(skuString);
    }

    @Test
    public void test5(){
        productDao pd = new productDaoImpl();
        Productspecificationdic psd = new Productspecificationdic();
        psd.setSpecificationDicName("颜色");
        psd.setCategoryID(28l);
        List<Productspecificationdic> productspecificationdics = pd.selectProductspecificationdicByID(psd);
        System.out.println(productspecificationdics.get(0).toString());
    }

    @Test
    public void test6(){
        productDao pd = new productDaoImpl();
        List<Productspecificationvalues> a = pd.selectProductspecificationvaluesBySIDAndName(new Productspecificationvalues(7l, "红色"));
        System.out.println(a.get(0));
    }

    @Test
    public void test2(){
        Map<String, String> skuMap = skuUtil.getSkuMap("{37:169,38:172}");
        System.out.println(skuMap.toString());
        String skuString = skuUtil.getSkuString(skuMap, 20l);
        System.out.println(skuString);
    }

    @Test
    public void test1(){
        productDao pd = new productDaoImpl();
        List<ProductDetailInfo> productDetailInfos = pd.selectProductDetail(new Product(1));
        for (ProductDetailInfo productDetailInfo : productDetailInfos) {
            productDetailInfo.setSkuAttribute(skuUtil.getSkuMap((String)productDetailInfo.getSkuAttribute()));
            System.out.println(productDetailInfo);
        }
    }

    @Test
    public void test(){
        JdbcTemplate temp = jdbcUtil.getJdbcTemplate();

        for(int i=0;i<200;i++){
            Random r = new Random();
            long l = Math.abs(r.nextLong());
            int update = temp.update("insert into user values (default,?,?,?,?,?,?,?,?,?,?,?)",
                    ("1"+l).substring(0, 11),
                    (""+l).substring((""+l).length()-6),
                    (""+l).substring((""+l).length()-6),
                    2,
                    "2000-04-27",
                    ("user"+l).substring(0, 8),
                    0,
                    0,
                    0,
                    "img/avatar5.png",
                    "D:\\Study\\iDealU\\WorkSpace\\UDai\\UDaiAdmin\\web\\img\\avatar5.png");
        }

    }
}
