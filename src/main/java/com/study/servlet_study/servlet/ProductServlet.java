package com.study.servlet_study.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.servlet_study.entity.Product;
import com.study.servlet_study.service.ProductService;


@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;
       
   
    public ProductServlet() {
        super();
        productService = ProductService.getIntance();
       
    }

	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int price = 0;
		
		try {
			price = Integer.parseInt(request.getParameter("price"));
		} catch (NumberFormatException e) {
			response.setStatus(400);
			response.getWriter().println("숫자만 입력해야합니다.");
			return;
		}
		
		String  productName = request.getParameter("productName");
		String  size = request.getParameter("size");
		String  color = request.getParameter("color");
		
		Product product = Product.builder()
						.productName(productName)
						.price(price)
						.size(size)
						.color(color)
						.build();
		
		if(productService.getProduct(product.getProductName()) != null ) {
			response.setStatus(400);
			response.getWriter().println("이미 등록된 상품명입니다.");
			return;
		}
		
		productService.addProduct(product);
		response.setStatus(201);
		response.getWriter().println("상품 등록이 완료되었습니다.");
		
		
		
		
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName = request.getParameter("productName");
		
		Product product = productService.getProduct(productName);
		response.setStatus(200);
		response.getWriter().println(product);	
		
	}

}