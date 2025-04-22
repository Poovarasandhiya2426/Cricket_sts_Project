package com.cricket.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cricket.entity.cricketEntityBean;
import com.cricket.repository.cricketRepository;



@Repository
public class cricketDao {
	
	@Autowired
	cricketRepository cr;

	public String postListOfObject(List<cricketEntityBean> c) {
		// TODO Auto-generated method stub
		cr.saveAll(c) ;
		
		return "Post Successfully" ;
	}

	public List<cricketEntityBean> getListofObject() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	public String updateobjects(int n, cricketEntityBean c) {
		// TODO Auto-generated method stub
		cricketEntityBean x=cr.findById(n).get();
		x.setPlayerName(c.getPlayerName());
		//x.setBowlingStyle(c.getBowlingStyle());
		//x.setAverage(c.getAverage());
		
		cr.save(x);
		
		return "Success" ;
	}

	public String patchsinglefield(int n, cricketEntityBean c) {
		// TODO Auto-generated method stub
		
		cricketEntityBean x=cr.findById(n).get();
		x.setPlayerName(c.getPlayerName());
		
		cr.save(x);
		return "DONE";
	}

	public List<cricketEntityBean> getTeam(String team) {
		// TODO Auto-generated method stub
		return cr.getTeam(team);
	}

	public List<cricketEntityBean> getPlayer(String a) {
		// TODO Auto-generated method stub
		return cr.getPlayer(a);
	}

	public cricketEntityBean getMaxRunPersonObj() {
		// TODO Auto-generated method stub
		return cr.getMaxRunPersonObj();
	}

	public List<String> getjercy7() {
		// TODO Auto-generated method stub
		return cr.getjercy7();
	}

	public List<String> getAusPlayerifAllrounder() {
		// TODO Auto-generated method stub
		return cr.getAusPlayerifAllrounder();
	}

	public List<cricketEntityBean> getAboveLimiOfRunObj(int a, int b) {
		// TODO Auto-generated method stub
		return cr.getAboveLimitOfRunObj(a,b); 
	}

	public List<String> getIndianBatsmanNameDesc() {
		// TODO Auto-generated method stub
		return cr.getIndianBatsmanNameDesc(); 
	}

	public Integer secondMaximumRun() {
		// TODO Auto-generated method stub
		return cr.secondMaximumRun();
	}

	public Integer getIndianRightHandBatsmanMinimumRun() {
		// TODO Auto-generated method stub
		return cr.getIndianRightHandBatsmanMinimumRun();
	}

	public String updateplayerscountry(int n, cricketEntityBean c) {
		// TODO Auto-generated method stub
		
		cricketEntityBean x=cr.findById(n).get();
		x.setCountry(c.getCountry());
		x.setCountry(c.getCountry());
	
		cr.save(x);
		return "Post Successfully" ;
	}

	public List<cricketEntityBean> getCountry(String a) {
		// TODO Auto-generated method stub
		return cr.getCountry(a);
	}

	

	public List<cricketEntityBean> getTop3Bowler() {
		// TODO Auto-generated method stub
		return cr.getTop3Bowler();
	}
	
	public List<cricketEntityBean> getUser(String a) {
		// TODO Auto-generated method stub
		return cr.getUser(a); 
	}

	public List<cricketEntityBean> getRole(String a) {
		// TODO Auto-generated method stub
		return cr.getRole(a);
	}

	public List<cricketEntityBean> getRoles(String a) {
		// TODO Auto-generated method stub
		return cr.getRole(a);
	}

	public cricketEntityBean getByid(int a) {
		// TODO Auto-generated method stub
		return cr.findById(a).get();
	}
	
	 

}
