package com.www.opeartor.dao;


import com.www.opeartor.core.dao.CommonDao;
import com.www.opeartor.entity.Material;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("rawtypes")
@Repository
public class MaterialDao extends CommonDao{
	
	private static Logger logger = LogManager.getLogger(MaterialDao.class);
	
	public List<Material> getMaterialList() {
		
		String sql = "select id,imgUrl from op_bd_image";
		logger.info("执行的sql : {}",sql);
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Material>(Material.class));
	}

	@Override
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
