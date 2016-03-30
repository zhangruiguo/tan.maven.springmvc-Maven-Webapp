package com.tan.model;

import java.util.HashMap;
import java.util.List;

public class ColValue {
	private List<HashMap<String, Object>> rows;
	public ColValue(){}
	public ColValue( List<HashMap<String, Object>> rows) {
		super();  
		setRows(rows);
	}
	public List<HashMap<String, Object>> getRows() {
		return rows;
	}
	public void setRows(List<HashMap<String, Object>> rows) {
		this.rows = rows;
	}
}
