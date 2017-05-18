package com.www.opeartor.dao;


import com.www.opeartor.entity.Operator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginDao {

	private static Logger logger = LogManager.getLogger(LoginDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Operator getUser(String userName) {
		String sql = "SELECT * from op_bd_user where userName =?";
		logger.info("执行的sql : {}",sql);
		logger.info("参数 : {}",userName);
		List<Operator> list = jdbcTemplate.query(sql, new Object[]{userName}, new BeanPropertyRowMapper(Operator.class));
		if(list!=null && !list.isEmpty())
			return list.get(0);
		
		return null;
	}
}
