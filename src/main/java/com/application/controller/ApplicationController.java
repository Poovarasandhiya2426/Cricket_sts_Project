package com.application.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.application.entity.ApplicationEntity;
import com.application.exceptionHandling.IdNotFoundException;
import com.application.exceptionHandling.NameNotFoundException;
import com.application.exceptionHandling.NameNotFoundExceptionJquery;
import com.application.exceptionHandling.ratingNotFoundException;
import com.application.service.ApplicationService;
import com.applicationPOJO.ElectronicsPoJo;
import com.applicationPOJO.EmployeePojo;


@RestController
public class ApplicationController {
	
	 @Autowired 
	 ApplicationService AS;
	 
	 
	 @PostMapping(value="/postListOfObj") 
	    public String postListOfObj(@RequestBody List<ApplicationEntity> C )  {
			return AS.postListOfObj(C);
	    	
	    }
	 
	 @GetMapping(value="/GetObjName/{name}")
	 public List<ApplicationEntity> getObjName(@PathVariable String name)  throws NameNotFoundException {
		return AS.getObjName(name);
		 
	 }
	 
	 @GetMapping(value="/GetObjid/{id}")
	 public List<ApplicationEntity> getObjName(@PathVariable int id)  throws IdNotFoundException {
		return AS.getObjid(id);
		 
	 }
	 
	 @GetMapping(value="/GetObjRating/{rating}")
	 public List<ApplicationEntity> getObjRating(@PathVariable int rating)  throws ratingNotFoundException {
		return AS.getObjRating(rating);
		 
	 }
	 
	 @GetMapping(value="/JqueryGetObjName{name}")
	 public List<ApplicationEntity> getJqueryGetObjName(@PathVariable String name)  throws NameNotFoundExceptionJquery {
			return AS.getJqueryGetObjName(name);
	 }
	 
	 @Autowired
	 RestTemplate rt;
	 
	 @GetMapping(value="/getWord")
	 public String getWord() {
		
		 String url="http://localhost:8080/get";
		 ResponseEntity<String> re=rt.exchange(url, HttpMethod.GET, null, String.class);
		 String result=re.getBody();
		 return result;
		 
	 }
	 
	 @GetMapping(value="/getName/{a}")
	 public String getName(@PathVariable String a) {
		 String url="http://localhost:8080/getThis/";
		ResponseEntity<String> re=rt.exchange(url+ a , HttpMethod.GET, null, String.class);
		 String result=re.getBody();
		 return result;
		 
	 }
	 
	 @GetMapping("/compareMax/{a}/{b}")
	 public String compareMax(@PathVariable int a, @PathVariable int b) {
	     String url = "http://localhost:8080/getMax/{a}/{b}";

	     ResponseEntity<String> response = rt.exchange(
	         url,
	         HttpMethod.GET,
	         null,
	         String.class,
	         a,
	         b
	     );

	     return response.getBody();
	 }
	 
	 
	 @GetMapping(value="/getObjects")
	 public List<ElectronicsPoJo> getObjects() {
		 String url="http://localhost:7777/getListObj";
		 ResponseEntity<List<ElectronicsPoJo>> re = rt.exchange(
				    url,
				    HttpMethod.GET,
				    null,
				    new ParameterizedTypeReference<List<ElectronicsPoJo>>() {}
				); 
		 
		 List<ElectronicsPoJo> result=re.getBody();
		 
		return result;		 
	
	 }
	 
	 @GetMapping(value="/getEmployeeObjects")
	 public List<EmployeePojo> getSingleObj() {
	 
	 String url="http://localhost:8056/getListObj";
	 ResponseEntity<List<EmployeePojo>> re = rt.exchange(
			    url,
			    HttpMethod.GET,
			    null,
			    new ParameterizedTypeReference<List<EmployeePojo>>() {}
			); 
	 
	 List<EmployeePojo> result=re.getBody();
	 
	return result;	

	 }
	 
	 
	 
	 
}
