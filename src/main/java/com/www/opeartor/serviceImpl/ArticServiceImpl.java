package com.www.opeartor.serviceImpl;

import com.www.opeartor.dao.ArticDao;
import com.www.opeartor.entity.Artic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ArticServiceImpl {
	
	private static Logger logger = LogManager.getLogger(ArticServiceImpl.class);
	
	@Autowired
	private ArticDao articDao;

	public Map<String, Object> saveArtic(Artic artic) {
		Map<String, Object> result = new HashMap<>();
		try {
			articDao.save(artic);
			result.put("code", "0000");
			result.put("codeDesc", "保存成功");
		} catch (Exception e) {
			logger.error("保存文章出错了");
			logger.error(e.getMessage());
			result.put("code", "0001");
			result.put("codeDesc", "保存失败");
		}
		return result;
	}

	public Map<String, Object> updateArtic(Artic artic) {
		Map<String, Object> result = new HashMap<>();
		try {
			articDao.update(artic);
			result.put("code", "0000");
			result.put("codeDesc", "修改成功");
		} catch (Exception e) {
			logger.error("修改文章出错了");
			logger.error(e.getMessage());
			result.put("code", "0001");
			result.put("codeDesc", "修改失败");
		}
		return result;
	}

	public Map<String, Object> getArticObject(Integer id) {
		Map<String, Object> result = new HashMap<>();
		try {
			Artic artic = new Artic();
			artic.setId(id);
			result.put("data",articDao.findObject(artic));
			result.put("code", "0000");
			result.put("codeDesc", "查询成功");
		} catch (Exception e) {
			logger.error("查询出错了");
			logger.error(e.getMessage());
			result.put("code", "0001");
			result.put("codeDesc", "查询成功");
		}
		return null;
	}

}
