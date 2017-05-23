package com.www.opeartor.serviceImpl;


import com.www.opeartor.dao.MaterialDaoMapper;
import com.www.opeartor.entity.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl {
	
	@Autowired
	private MaterialDaoMapper dao;

	public void saveMaterial(String imgUrl) {
		Material material = new Material(imgUrl);
		dao.save(material);
	}

	public List<Material> getMaterialList() {
		return dao.getMaterialList();
	}

}
