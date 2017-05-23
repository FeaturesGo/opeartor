package com.www.opeartor.dao;

import org.springframework.stereotype.Repository;

import com.www.opeartor.entity.Tourist;

@Repository
public interface TouristDaoMapper {

	void save(Tourist tourist);

}
