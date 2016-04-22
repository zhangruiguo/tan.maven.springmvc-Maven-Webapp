package com.tan.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.manager.Serialize;
import com.tan.db.DBHelper;
import com.tan.model.Book;
import com.tan.service.BookService;




@Controller
@RequestMapping("/book.do")
public class BookController {

	private BookService bookService;

	@RequestMapping(params = "method=add")
	public String add(Book book) {
		System.out.println("bookname:" + book.getName());
		System.out.println("author:" + book.getAuthor());
		System.out.println("by zrg");
		bookService.add(book);
		return "success";
	}
	@RequestMapping(params = "method=select")
	@ResponseBody
	public String select() {
		return "success";
	}
	
	@RequestMapping(params = "method=update")
	public String update(Book book) {
		bookService.update(book);
		return "success";
	}
	
	
	@RequestMapping(params = "method=Getstr1")
	@ResponseBody
	public String Getstr1(){ 
		String output = null;
		try {
			String targetURL = "http://wisdomhunter.tpddns.cn:8081/RESTfulExample/customer/print";
            URL restServiceURL = new URL(targetURL);

            HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();
            httpConnection.setRequestMethod("GET");
            httpConnection.setRequestProperty("Accept", "application/json");

            if (httpConnection.getResponseCode() != 200) {
                   throw new RuntimeException("HTTP GET Request Failed with Error code : "
                                 + httpConnection.getResponseCode());
            }

            BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
                   (httpConnection.getInputStream())));

            output = responseBuffer.readLine();

            httpConnection.disconnect();

       } catch (MalformedURLException e) {

            e.printStackTrace();

       } catch (IOException e) {

            e.printStackTrace();

       }
		return output;
	}

	public BookService getBookService() {
		return bookService;
	}

	@Resource
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	static DBHelper db1 = null;
	static ResultSet rs = null;
	static java.sql.ResultSetMetaData data = null;
	@ResponseBody
	@RequestMapping(params = "method=getdata",produces="application/json")
	public Map getdata(String sql) throws JSONException {
		HashMap<String, Object> mp = new HashMap<String, Object>();
		db1 = new DBHelper(sql);// 创建DBHelper对象
		try {
			rs = db1.pst.executeQuery();// 执行语句，得到结果集
			data = rs.getMetaData();
			mp = Serialize.SerializeWithRequest(rs, data, ",");
			rs.last();
			db1.close();// 关闭连接
		} catch (SQLException e) {
			mp = Serialize.ReturnErr(e.getMessage());
			e.printStackTrace();
		}
		return mp;
	}
	@ResponseBody
	@RequestMapping(params = "method=getmenu")
	public List getmenu() throws JSONException {
		List<HashMap<String, Object>> ls = new ArrayList<HashMap<String, Object>>();

		ls = com.manager.Common.getMeunList();
		return ls;
	}
	
	@ResponseBody
	@RequestMapping(params = "method=getmenustr",produces="application/json;charset=UTF-8")
	public  String getmenustr() throws JSONException { 
		String str=null;
		str = com.manager.Common.GetMeunStr();
		String alibabaJson = JSON.toJSONString(str);
		return alibabaJson;
	}
}
