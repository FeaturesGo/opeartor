package com.www.opeartor.core.util;

import java.util.List;


/***
 * 
 * @author wangweiwei
 *
 */
public class DBParamUtil {
	
	private String sql;
	private List<Object> param;
	
	public DBParamUtil() {
	}
	
	
	
	public DBParamUtil(String sql) {
		this.sql = sql;
	}


	public DBParamUtil(String sql, List<Object> param) {
		this.sql = sql;
		this.param = param;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public List<Object> getParam() {
		return param;
	}
	public void setParam(List<Object> param) {
		this.param = param;
	}
	
	
	

}
