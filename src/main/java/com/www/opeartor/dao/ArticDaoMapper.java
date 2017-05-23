package com.www.opeartor.dao;

import com.www.opeartor.entity.Artic;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticDaoMapper {
	
	int save(Artic artic);

	int update(Artic artic);

	Object findObject(Integer id);

	int getArticListCount();

	List<Artic> getArticList(@Param(value="start")int startIn, @Param(value="pageSize")Integer pageSize);

}
