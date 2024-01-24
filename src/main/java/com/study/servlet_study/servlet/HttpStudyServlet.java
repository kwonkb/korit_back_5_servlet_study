package com.study.servlet_study.servlet;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.servlet_study.utils.ParamsConverter;


@WebServlet("/http")
public class HttpStudyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public HttpStudyServlet() {
        super();
        
    }
    
    //HTTP 메소드
    // post요청 -> create(추가)
    //get 요청 -> Read(조회)
    // put 요청 -> Update(수정)
    // DELETE 요청 -> Delete(삭제)
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    	
    	Map<String, String> paramsMap = new HashMap<>();
    	
    	request.getParameterMap().forEach((k, v) -> {
    		StringBuilder builder = new StringBuilder();
    		
    		
    		Arrays.asList(v).forEach(value -> builder.append(value));
    		
    		
    		paramsMap.put(k, builder.toString());
    		
    	});
    	
    	System.out.println(paramsMap);
    	
    	
    	Map<String, String> paramsMap2 = new HashMap<>();
    	Iterator<String> ir = request.getParameterNames().asIterator();
    	while(ir.hasNext()) {
    		String key = ir.next();
    		paramsMap2.put(key,request.getParameter(key));
    		
    	}
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> paramsMap = ParamsConverter.convertParamsMapToMap(request.getParameterMap());
		
		System.out.println(paramsMap);
    }


	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
