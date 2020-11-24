package com.RSnowBEar.servlet;

import com.RSnowBEar.dao.impl.productDaoImpl;
import com.RSnowBEar.dao.productDao;
import com.RSnowBEar.entity.Productcategorydic;
import com.RSnowBEar.util.jsonReader;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/queryCategoryServlet")
public class queryCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String queryString = request.getQueryString();
        String categoryID = queryString.split("=")[1];
        productDao pd = new productDaoImpl();
        Productcategorydic productcategorydic = new Productcategorydic();
        productcategorydic.setPid(Long.valueOf(categoryID));
        List<Productcategorydic> productcategorydics = pd.selectProductCategoryByPID(productcategorydic);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),productcategorydics);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
