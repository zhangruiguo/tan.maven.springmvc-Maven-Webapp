package com.tan.controller;

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
import com.tan.db.DBHelper;
import com.tan.model.Book;
import com.tan.service.BookService;
import org.json.JSONException;
import com.manager.Serialize;

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

	@RequestMapping(params = "method=update")
	public String update(Book book) {
		bookService.update(book);
		return "success";
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

	@RequestMapping(params = "method=getdata")
	@ResponseBody
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

	@RequestMapping(params = "method=getmenu")
	@ResponseBody
	public List getmenu() throws JSONException {
		List<HashMap<String, Object>> ls = new ArrayList<HashMap<String, Object>>();

		ls = com.manager.Common.getMeunList();
		return ls;
	}
}
