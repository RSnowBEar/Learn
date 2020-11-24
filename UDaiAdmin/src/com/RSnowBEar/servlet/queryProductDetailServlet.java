package com.RSnowBEar.servlet;

import com.RSnowBEar.dao.impl.productDaoImpl;
import com.RSnowBEar.dao.productDao;
import com.RSnowBEar.entity.Product;
import com.RSnowBEar.entity.ProductDetailInfo;
import com.RSnowBEar.entity.Productcategorydic;
import com.RSnowBEar.entity.Productspecificationdic;
import com.RSnowBEar.service.impl.productServiceImpl;
import com.RSnowBEar.service.productService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/queryProductDetailServlet")
public class queryProductDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long productID = Long.valueOf(request.getParameter("productID"));
        productService ps = new productServiceImpl();
        List<ProductDetailInfo> productDetailInfos = ps.queryProductDetail(new Product(productID));
        Long category3 = productDetailInfos.get(0).getCategoryID().longValue();
        productDao pd = new productDaoImpl();
        Productcategorydic pcd = pd.selectProductCategoryByID(new Productcategorydic(category3)).get(0);
        String category3Name = pcd.getCategoryName();
        Long category2 = pcd.getPid();
        pcd = pd.selectProductCategoryByID(new Productcategorydic(category2)).get(0);
        String category2Name = pcd.getCategoryName();
        Long category1 = pcd.getPid();
        pcd = pd.selectProductCategoryByID(new Productcategorydic(category1)).get(0);
        String category1Name = pcd.getCategoryName();

        request.setAttribute("category3",category3Name);
        request.setAttribute("category2",category2Name);
        request.setAttribute("category1",category1Name);


        request.setAttribute("productDetailList", productDetailInfos);
        request.getRequestDispatcher("jsp/product-detail-all.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
