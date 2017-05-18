package com.www.opeartor.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.www.opeartor.core.dao.CommonDao;

@Repository
public class ArticDao extends CommonDao{
	
	//private static Logger logger = LogManager.getLogger(LoginDao.class);
	
	@Autowired
	public void setJdbcTemplate (JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return this.jdbcTemplate;
	}

	
	
/*	public void updateArtic(final Artic artic) {
		
		DBParamUtil dbParamUtil = DBSqlUtil.getUpdateSqlAndParam(artic);
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
	}*/

/*	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object getArticObject(final Artic artic) {
		DBParamUtil dbParamUtil = DBSqlUtil.getSelectSqlAndParam(artic);
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
				
			}}, new BeanPropertyRowMapper(artic.getClass()));
		
		if(data!=null && !data.isEmpty())
			return data.get(0);
		return null;
	}*/
	

}
