package com.study.servlet_study.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.study.servlet_study.config.DBConnectionMgr;
import com.study.servlet_study.entity.Author;

public class DBConnectionTestMain {
	
	public static void main(String[] args) {
		DBConnectionMgr pool = DBConnectionMgr.getInstance();
		
		Connection con = null;
		PreparedStatement pstmt = null;	
		ResultSet rs = null;
		try {
			 con = pool.getConnection();
			 String name = "송희창";
			String sql = "select * from author_tb where author_name = ?";
			 pstmt = con.prepareStatement(sql);
			 pstmt.setString(1, name); // 표현식
			 rs = pstmt.executeQuery();
			List<Author> authorList = new ArrayList<>();
			
			while(rs.next()) {
				authorList.add(Author.builder()
						.authorId(rs.getInt(1))
						.authorName(rs.getString(2))
						.build());
			
			}
			authorList.forEach(author -> System.out.println(author));
			for(Author author : authorList) {
				System.out.println(author);
			}
			
			for(int i = 0; i < authorList.size(); i++) {
				Author author = authorList.get(i);
				System.out.println(author);
			}
			
	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con,pstmt,rs);
		}
		
	}

}
