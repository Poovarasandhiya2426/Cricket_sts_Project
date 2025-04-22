package com.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.application.entity.ApplicationEntity;

public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Integer> {

	//native Query....
	@Query(value="select * from application_details  where name=?;", nativeQuery=true)
	public List<ApplicationEntity> getObjName(String name);

	@Query(value="select * from application_details  where id=?;", nativeQuery=true)
	public List<ApplicationEntity> getObjid(int id);

	
	@Query(value="select * from application_details  where rating=?;", nativeQuery=true)
	public List<ApplicationEntity> getObjRating(int rating);

	
	
	//Jquery
	
	@Query("select c from ApplicationEntity c where c.name = :name")
	public List<ApplicationEntity> getJqueryGetObjName(@Param("name") String name);

}

