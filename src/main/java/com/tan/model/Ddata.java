package com.tan.model;

public class Ddata { 
	private ColName columns;
	private ColValue rows;
	public Ddata(){}
	public Ddata(  ColName columns, ColValue rows) {
		super();  
		setColumns(columns);
		setRows(rows);
	}
	public ColValue getRows() {
		return rows;
	}
	public void setRows(ColValue rows) {
		this.rows = rows;
	}
	public ColName getColumns() {
		return columns;
	}
	public void setColumns(ColName columns) {
		this.columns = columns;
	}
}
