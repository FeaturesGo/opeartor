package com.www.opeartor.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.www.opeartor.entity.Material;

@Repository
public interface MaterialDaoMapper {

	void save(Material material);

	List<Material> getMaterialList();

}
