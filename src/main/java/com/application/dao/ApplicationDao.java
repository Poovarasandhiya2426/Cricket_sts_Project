package com.application.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.entity.ApplicationEntity;
import com.application.repository.ApplicationRepository;

@Repository
public class ApplicationDao {
	
	@Autowired
	ApplicationRepository AR;

	public String postListOfObj(List<ApplicationEntity> C) {
		// TODO Auto-generated method stub
		
		AR.saveAll(C);
		return "Successfully" ;
	}

	public List<ApplicationEntity> getObjName(String name) {
		// TODO Auto-generated method stub
		return AR.getObjName(name);
	}


	public List<ApplicationEntity> getObjid(int id) {
		// TODO Auto-generated method stub
		return AR.getObjid(id);
	}
	
	public List<ApplicationEntity> getObjRating(int rating) {
		// TODO Auto-generated method stub
		return AR.getObjRating(rating);
	}
	
	public List<ApplicationEntity> getJqueryGetObjName(String name) {
		// TODO Auto-generated method stub
		return AR.getJqueryGetObjName(name);
	}

}
