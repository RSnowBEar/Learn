package com.RSnowBEar.servlet;

import com.RSnowBEar.dao.impl.productDaoImpl;
import com.RSnowBEar.dao.productDao;
import com.RSnowBEar.entity.Product;
import com.RSnowBEar.entity.Productsku;
import com.RSnowBEar.entity.Productspecificationdic;
import com.RSnowBEar.entity.Productspecificationvalues;
import com.RSnowBEar.service.impl.productServiceImpl;
import com.RSnowBEar.service.productService;
import com.RSnowBEar.util.jsonReader;
import com.RSnowBEar.util.skuUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

@WebServlet("/addProductServlet")
public class addProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productDao pd = new productDaoImpl();

        //获取数据
        String data = request.getParameter("data");
        data = data.substring(1,data.length()-1);

        String[] split = data.split(",");

        String productName = split[0].substring(split[0].indexOf(":")+1);
        Long categoryId = Long.valueOf(split[1].substring(split[1].indexOf(":")+1));

        //创建商品对象
        Product p = new Product();
        p.setProductName(productName);
        p.setCategoryID(Integer.valueOf((int)(long)categoryId));
        p.setShelfTime(new Timestamp(new Date().getTime()));
        p.setShelfStatus(0);
        p.setImgRelativePath("");
        p.setImgRealPath("");


        //创建sku属性列表
        List<Productsku> skuList = new ArrayList<>();

        for(int i=2;i<split.length;i+=4){
            Productsku psku = new Productsku();

            //获取sku属性
            Map<String,String> map = new HashMap<>();
            for(int j=i;j<i+2;j++) {
                String specificationID1 = split[j].substring(split[j].indexOf(":")+1);
                Productspecificationvalues psv1 = pd.selectProductspecificationvaluesByID(specificationID1).get(0);
                String specificationName = psv1.getSpecificationName();
                Long psdID = psv1.getSpecificationDicId();
                Productspecificationdic psd = pd.selectProductspecificationdicByID("" + psdID).get(0);
                String specificationDicName = psd.getSpecificationDicName();
                map.put(specificationDicName, specificationName);
            }

            String skuAttribute = skuUtil.getSkuString(map, categoryId);
            psku.setSkuAttribute(skuAttribute);

            //获取单价&库存
            String price = split[i+2].substring(split[i+2].indexOf(":")+1);
            psku.setPrice(Double.valueOf(price));

            String inventory = split[i+3].substring(split[i+3].indexOf(":")+1);
            psku.setInventory(Long.valueOf(inventory));

            //将对象存入list
            skuList.add(psku);
        }
        //调用添加商品的方法
        productService ps = new productServiceImpl();
        boolean b = ps.insertProduct(p, skuList);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
