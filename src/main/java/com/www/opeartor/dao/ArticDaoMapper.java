package com.www.opeartor.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.www.opeartor.entity.Artic;

@Repository
public interface ArticDaoMapper {
	
	int save(Artic artic);

	int update(Artic artic);

	Object findObject(Integer id);

	int getArticListCount();

	List<Artic> getArticList(@Param(value="start")int startIn, @Param(value="pageSize")Integer pageSize);

}
