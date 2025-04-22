package com.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.application.dao.ApplicationDao;
import com.application.entity.ApplicationEntity;
import com.application.exceptionHandling.IdNotFoundException;
import com.application.exceptionHandling.NameNotFoundException;
import com.application.exceptionHandling.NameNotFoundExceptionJquery;
import com.application.exceptionHandling.ratingNotFoundException;

@Service
public class ApplicationService {
	
	@Autowired
	ApplicationDao AD;
	
	
	 
	public String postListOfObj( List<ApplicationEntity> C) {
		// TODO Auto-generated method stub
		return AD.postListOfObj(C);
	}



	public List<ApplicationEntity> getObjName(String name) throws NameNotFoundException {
		// TODO Auto-generated method stub
		
		if(AD.getObjName(name).isEmpty()) {
			throw new NameNotFoundException() ;
		}
		
		else {
			return AD.getObjName(name);
		}
	 
	}



	public List<ApplicationEntity> getObjid(int id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if(AD.getObjid(id).isEmpty()) {
			throw new IdNotFoundException("No Data") ;
		}
		
		else {
			return AD.getObjid(id);
		}
	 
	}



	public List<ApplicationEntity> getObjRating(int rating) throws ratingNotFoundException {
		// TODO Auto-generated method stub
		if(AD.getObjRating(rating).isEmpty()) {
			throw new ratingNotFoundException("No rating") ;
		}
		
		else {
			return AD.getObjRating(rating);
		}
	}



	public List<ApplicationEntity> getJqueryGetObjName(String name) throws NameNotFoundExceptionJquery {
		// TODO Auto-generated method stub
		
		if(AD.getJqueryGetObjName(name).isEmpty()) {
			throw new NameNotFoundExceptionJquery("Jquery No Data") ;
		}
		
		else {
			return AD.getJqueryGetObjName(name);
		}

	}
	
	

}
