package com.www.opeartor.core.util;

import com.www.opeartor.core.annotate.CustomTable;
import com.www.opeartor.core.annotate.CustomTranslate;
import com.www.opeartor.core.entity.CommonEntity;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

/***
 * 
 * @author hwg
 *
 */
public class DBSqlUtil {
	
	private static Logger logger = LogManager.getLogger(DBSqlUtil.class);
	
	public static DBParamUtil getInsertSqlAndParam(CommonEntity comm) {
		
		CustomTable slef = comm.getClass().getAnnotation(CustomTable.class);
		if(slef==null)
			throw new RuntimeException("参数类没有TableSlef注解");
		
		//获取表明
		String tableName = slef.tableName();
		logger.info("执行数据的表明：{}",tableName);
		StringBuffer bufferPre = new StringBuffer();
		StringBuffer bufferSuf = new StringBuffer();
		List<Object> param = null;
		try{
			//获取属性
			PropertyDescriptor[] propers = PropertyUtils.getPropertyDescriptors(comm.getClass());
			
			bufferPre.append("insert into ")
					.append(tableName)
					.append("(");
			bufferSuf.append(" values (");
			param = new ArrayList<>();
			for(PropertyDescriptor pd:propers) {
				if(pd.getClass().getAnnotation(CustomTranslate.class)!=null) {
					continue;
				}
				String filedName = pd.getName();
				if(filedName.startsWith("class")){
					continue;
				}
				if(filedName.equals("createTime") || filedName.equals("updateTime")) {
					bufferPre.append(filedName).append(",");
					bufferSuf.append("now()").append(",");
				}
				//获取值
				Object value = PropertyUtils.getProperty(comm, filedName);
				if(value==null)
					continue;
				param.add(value);
				bufferPre.append(filedName).append(",");
				bufferSuf.append("?").append(",");
				
			}
			bufferPre.deleteCharAt(bufferPre.length()-1).append(")");
			bufferSuf.deleteCharAt(bufferSuf.length()-1).append(")");
		} catch (Exception e) {
			logger.error("获取insert语句报错,getInsertSqlAndParam");
			logger.error(e.getMessage());
		}
		return new DBParamUtil(bufferPre.toString()+" "+bufferSuf.toString(),param);
	}
	
	
	public static DBParamUtil getUpdateSqlAndParam(CommonEntity comm) {
		
		CustomTable slef = comm.getClass().getAnnotation(CustomTable.class);
		if(slef==null)
			throw new RuntimeException("参数类没有TableSlef注解");
		
		StringBuffer bufferPre = new StringBuffer();
		List<Object> param = new ArrayList<>();
		try{
			//获取表名
			String tableName = slef.tableName();
			logger.info("执行数据的表名：{}",tableName);
			//获取主键
			String primaryKey = slef.primaryKey();
			//获取主键对应的值
			Object primaryKeyValue = PropertyUtils.getProperty(comm, primaryKey);
			if(primaryKeyValue == null) {
				throw new RuntimeException("参数的主键没有设值");
			}
			
			bufferPre.append("update ")
					.append(tableName)
					.append(" set ");
			//获取属性
			PropertyDescriptor[] propers = PropertyUtils.getPropertyDescriptors(comm.getClass());
			for(PropertyDescriptor pd:propers) {
				if(pd.getClass().getAnnotation(CustomTranslate.class)!=null) {
					continue;
				}
				String filedName = pd.getName();
				if(filedName.startsWith("class") || filedName.equals("createTime")
						|| filedName.equals(primaryKey)){
					continue;
				}
				if(filedName.equals("updateTime")) {
					bufferPre.append(filedName).append("=now(),");
				}
				
				//获取值
				Object value = PropertyUtils.getProperty(comm, filedName);
				if(value==null)
					continue;
				param.add(value);
				bufferPre.append(filedName).append("=?,");
			}
			param.add(primaryKeyValue);
			bufferPre.deleteCharAt(bufferPre.length()-1)
					.append(" where ")
					.append(primaryKey)
					.append("=?");
		} catch (Exception e) {
			logger.error("获取update语句报错,getUpdateSqlAndParam");
			logger.error(e.getMessage());
			if(e instanceof RuntimeException)
				throw (RuntimeException)e;
		}
		return new DBParamUtil(bufferPre.toString(),param);
	}
	
	public static DBParamUtil getSelectSqlAndParam(CommonEntity comm) {
		CustomTable slef = comm.getClass().getAnnotation(CustomTable.class);
		if(slef==null)
			throw new RuntimeException("参数类没有TableSlef注解");
		
		StringBuffer bufferPre = new StringBuffer();
		List<Object> param = new ArrayList<>();
		try{
			
			//获取表名
			String tableName = slef.tableName();
			logger.info("执行数据的表名：{}",tableName);
			//获取主键
			String primaryKey = slef.primaryKey();
			//获取主键对应的值
			Object primaryKeyValue = PropertyUtils.getProperty(comm, primaryKey);
			if(primaryKeyValue == null) {
				throw new RuntimeException("参数的主键没有设值");
			}
			bufferPre.append("select * from ")
						.append(tableName)
						.append(" where ")
						.append(primaryKey)
						.append("=?");
			param.add(primaryKeyValue);
			
		} catch (Exception e) {
			logger.error("获取select语句报错,getSelectSqlAndParam");
			logger.error(e.getMessage());
			if(e instanceof RuntimeException)
				throw (RuntimeException)e;
		}
		return new DBParamUtil(bufferPre.toString(),param);
	}
	
	
	public static DBParamUtil getDeleteSqlAndParam(CommonEntity comm) {
		
		CustomTable slef = comm.getClass().getAnnotation(CustomTable.class);
		if(slef==null)
			throw new RuntimeException("参数类没有TableSlef注解");
		
		StringBuffer bufferPre = new StringBuffer();
		List<Object> param = new ArrayList<>();
		try{
		
			//获取表名
			String tableName = slef.tableName();
			logger.info("执行数据的表名：{}",tableName);
			//获取主键
			String primaryKey = slef.primaryKey();
			//获取主键对应的值
			Object primaryKeyValue = PropertyUtils.getProperty(comm, primaryKey);
			if(primaryKeyValue == null) {
				throw new RuntimeException("参数的主键没有设值");
			}
			
			bufferPre.append("DELETE from ")
					.append(tableName)
					.append(" where ")
					.append(primaryKey)
					.append("=?");
			param.add(primaryKeyValue);		
			
		} catch (Exception e) {
			logger.error("获取insert语句报错,getSelectSqlAndParam");
			logger.error(e.getMessage());
			if(e instanceof RuntimeException)
				throw (RuntimeException)e;
		}
		return new DBParamUtil(bufferPre.toString(),param);
	}

}
