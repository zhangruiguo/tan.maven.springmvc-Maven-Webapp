package com.tan.model;

import java.util.HashMap;
import java.util.List;

public class ColName {
	private List<HashMap<String, Object>> columns;
	public ColName(){}
	public ColName( List<HashMap<String, Object>> columns) {
		super();   
		setColumns(columns);
	}
	public List<HashMap<String, Object>> getColumns() {
		return columns;
	}
	public void setColumns(List<HashMap<String, Object>> columns) {
		this.columns = columns;
	}

}
