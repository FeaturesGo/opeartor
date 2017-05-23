package com.www.opeartor.core.dao;

import com.www.opeartor.core.entity.CommonEntity;
import com.www.opeartor.core.util.DBParamUtil;
import com.www.opeartor.core.util.DBSqlUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/***
 * 
 * @author wangweiwei
 *
 * @param <T>
 */
public abstract class CommonDao<T> {
	
	private static Logger logger = LogManager.getLogger(CommonDao.class);
	
	public JdbcTemplate jdbcTemplate;
	
	public abstract void setJdbcTemplate(JdbcTemplate jdbcTemplate);
	
	public void save(CommonEntity entity) {
		DBParamUtil dbParamUtil = DBSqlUtil.getInsertSqlAndParam(entity);
		String sql = dbParamUtil.getSql();
		if(sql==null)
			return;
		final List<Object> param = dbParamUtil.getParam();
		logger.info("执行的sql : {}",sql);
		logger.info("参数 : {}",param);
		jdbcTemplate.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				int i = 1;
				for(Object o:param) {
					ps.setObject(i, o);
					i++;
				}
			}
			
		});
	}
	
	public void update(CommonEntity entity) {
		
		DBParamUtil dbParamUtil = DBSqlUtil.getUpdateSqlAndParam(entity);
		String sql = dbParamUtil.getSql();
		if(sql==null)
			return;
		final List<Object> param = dbParamUtil.getParam();
		logger.info("执行的sql : {}",sql);
		logger.info("参数 : {}",param);
		jdbcTemplate.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				int i = 1;
				for(Object o:param) {
					ps.setObject(i, o);
					i++;
				}
			}
		});
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T findObject(CommonEntity entity) {
		DBParamUtil dbParamUtil = DBSqlUtil.getSelectSqlAndParam(entity);
		String sql = dbParamUtil.getSql();
		if(sql==null)
			return null;
		final List<Object> param = dbParamUtil.getParam();
		logger.info("执行的sql : {}",sql);
		logger.info("参数 : {}",param);
		List<Object> data = jdbcTemplate.query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				int i = 1;
				for(Object o:param) {
					ps.setObject(i, o);
					i++;
				}
			}}, new BeanPropertyRowMapper(entity.getClass()));
		
		if(data!=null && !data.isEmpty())
			return (T)data.get(0);
		return null;
		
	}

}
