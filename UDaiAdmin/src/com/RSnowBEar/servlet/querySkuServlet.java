package com.RSnowBEar.servlet;

import com.RSnowBEar.dao.impl.productDaoImpl;
import com.RSnowBEar.dao.productDao;
import com.RSnowBEar.entity.Productcategorydic;
import com.RSnowBEar.entity.Productspecificationdic;
import com.RSnowBEar.entity.Productspecificationvalues;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/querySkuServlet")
public class querySkuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String queryString = request.getQueryString();
        String categoryID = queryString.split("=")[1];
        productDao pd = new productDaoImpl();
        Productcategorydic pc = new Productcategorydic();
        pc.setCategoryId(Long.valueOf(categoryID));
        List<Productspecificationdic> productspecificationdics = pd.selectProductspecificationdicByCID(pc);
        List list = new ArrayList();
        for (Productspecificationdic productspecificationdic : productspecificationdics) {
            List<Productspecificationvalues> psvs = pd.selectProductspecificationvaluesBySID(productspecificationdic);
            list.add(psvs);
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),list);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
