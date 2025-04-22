package com.cricket.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.ExceptionHandler.CountryNotFoundException;
import com.cricket.ExceptionHandler.PlayerNotFoundException;
import com.cricket.ExceptionHandler.RoleNotFoundException;
import com.cricket.ExceptionHandler.TeamNotFoundException;
import com.cricket.dao.cricketDao;
import com.cricket.entity.cricketEntityBean;
import com.cricket.repository.cricketRepository;

@Service
public class cricketService {

	@Autowired
	cricketDao cd;

	public String postListOfObject(List<cricketEntityBean> c) {
		// TODO Auto-generated method stub
		return cd.postListOfObject(c);
	}

	public List<cricketEntityBean> getListofObject() {
		// TODO Auto-generated method stub
		return cd.getListofObject();
	}

	public String updateobjects(int n, cricketEntityBean c) {
		// TODO Auto-generated method stub
		return cd.updateobjects(n, c);
	}

	public String patchsinglefield(int n, cricketEntityBean c) {
		return cd.patchsinglefield(n, c);
	}

	@Autowired
	cricketRepository cr;

	/*
	public cricketEntityBean getmaximumRun(cricketEntityBean c) {
		// TODO Auto-generated method stub

		List<cricketEntityBean> x = cr.findAll();

		cricketEntityBean y = x.stream().max(Comparator.comparing(cricketEntityBean::getRuns)).get();

		return y;
	}
	*/
	
	 public cricketEntityBean getmaximumRun(cricketEntityBean c) {
		
		List<cricketEntityBean> x= cr.findAll();
		
		int max1=0;
		int max2=0;
		
		cricketEntityBean bean2=null;
		
		for(int i=0; i<x.size() ;i++) {
			if(x.get(i).getRuns()>max1) {
				max1=x.get(i).getRuns();
			}
		}
		
		for(int j=0; j<x.size(); j++) {
			if(x.get(j).getRuns()>max2 && x.get(j).getRuns()<max1) {
				max2=x.get(j).getRuns();
				
				bean2=x.get(j);
			}
		}
		
		return bean2;
		
	} 
	
	

	public Integer getmaximumrunonly(cricketEntityBean c) {
		// TODO Auto-generated method stub
		List<cricketEntityBean> x = cr.findAll();
		return x.stream().map(z -> z.getRuns()).max(Comparable::compareTo).get();
	}

	public List<cricketEntityBean> getIndianPlayerOnly(cricketEntityBean c) {
		// TODO Auto-generated method stub

		List<cricketEntityBean> x = cr.findAll();

		List<cricketEntityBean> y = x.stream().filter(z -> z.getCountry().equals("INDIA")).toList();

		return y;
	}

	public List<cricketEntityBean> getJercyNo7(cricketEntityBean c) {
		// TODO Auto-generated method stub
		List<cricketEntityBean> x = cr.findAll();

		List<cricketEntityBean> y = x.stream().filter(z -> z.getJerseyNumber() == 7).toList();
		return y;

	}

	public List<String> Australinaplayernameifallground(cricketEntityBean c) {
		// TODO Auto-generated method stub
		List<cricketEntityBean> x = cr.findAll();

		List<String> y = x.stream().filter(z -> z.getCountry().equals("AUSTRALIA") && z.getRole().equals("All-Rounder"))
				.map(cricketEntityBean::getPlayerName).toList();
		return y;
	}

	public List<String> getAboverangeofRun(int a, int b, cricketEntityBean c) {
		// TODO Auto-generated method stub

		List<cricketEntityBean> x = cr.findAll();
		List<String> y = x.stream().filter(z -> z.getRuns() > a && z.getRuns() < b)
				.map(cricketEntityBean::getPlayerName).toList();

		return y;
	}

	public List<cricketEntityBean> getIndianPlayerBatsmanOnly(cricketEntityBean c) {
		// TODO Auto-generated method stub
		List<cricketEntityBean> x = cr.findAll();
		List<cricketEntityBean> y = x.stream()
				.filter(z -> z.getRole().equals("Batsman") && z.getCountry().equals("INDIA")).toList();
		return y;
	}

	public long getIndianPlayerscountRightHand(cricketEntityBean c) {
		List<cricketEntityBean> x = cr.findAll();

		long y = x.stream()
				.filter(z -> z.getCountry().equals("INDIA") && z.getBattingStyle().equals("Right-Hand Batsman"))
				.count();
		return y;
	}

	public Integer getIndianPlayersRunstotal(cricketEntityBean c) {
		// TODO Auto-generated method stub
		List<cricketEntityBean> x = cr.findAll();

		Integer y = x.stream().filter(z -> z.getCountry().equals("INDIA"))
				.collect(Collectors.summingInt(z -> z.getRuns()));
		return y;
	}

	public Integer getSecondMaximumRuns(cricketEntityBean c) {
		// TODO Auto-generated method stub

		List<cricketEntityBean> x = cr.findAll();

		Integer y = x.stream().map(cricketEntityBean::getRuns).sorted(Comparator.reverseOrder()).skip(1).findFirst()
				.get();
		return y;
	}

	public Integer getSecondMinimumRuns(cricketEntityBean c) {
		// TODO Auto-generated method stub

		List<cricketEntityBean> x = cr.findAll();

		Integer y = x.stream().map(cricketEntityBean::getRuns).sorted().skip(1).findFirst().get();
		return y;
	}

	public Map<String, Long> getgroupbyindianplayers(cricketEntityBean c) {
		// TODO Auto-generated method stub
		List<cricketEntityBean> x = cr.findAll();

		Map<String, Long> y = x.stream().filter(p -> p.getCountry().equalsIgnoreCase("INDIA")) // filter Indian players
				.collect(Collectors.groupingBy(cricketEntityBean::getPlayerName, // group by team
						Collectors.counting() // count how many in each
				));

		return y;
	}

	public List<String> getAscPlayerName(cricketEntityBean c) {
		// TODO Auto-generated method stub
		List<cricketEntityBean> x = cr.findAll();

		List<String> y = x.stream().map(cricketEntityBean::getPlayerName).sorted().toList();
		return y;
	}

	public List<String> getDescPlayerName(cricketEntityBean c) {
		// TODO Auto-generated method stub
		List<cricketEntityBean> x = cr.findAll();

		List<String> y = x.stream().map(cricketEntityBean::getPlayerName).sorted(Comparator.reverseOrder()).toList();
		return y;
	}

	public Map<String, Long> getIndianPlayerlefthandbatsmanGroupby() {
		// TODO Auto-generated method stub
		List<cricketEntityBean> x = cr.findAll();

		Map<String, Long> y = x.stream()
				.filter(z -> z.getBattingStyle().equals("Left-Hand Batsman") && z.getCountry().equals("INDIA"))
				.collect(Collectors.groupingBy(z -> z.getPlayerName(), Collectors.counting()));
		return y;
	}

	public List<cricketEntityBean> getTeam(String team) throws TeamNotFoundException {
		// TODO Auto-generated method stub

		if (cd.getTeam(team).isEmpty()) {
			throw new TeamNotFoundException("Not Available this team");
		} else {
			return cd.getTeam(team);
		}

	}

	public List<cricketEntityBean> getPlayer(String a) throws PlayerNotFoundException {
		// TODO Auto-generated method stub

		if (cd.getPlayer(a).isEmpty()) {
			throw new PlayerNotFoundException("This player UNSOLD");
		} else {
			return cd.getPlayer(a);

		}

	}

	public cricketEntityBean getMaxRunPersonObj() {
		// TODO Auto-generated method stub
		return cd.getMaxRunPersonObj();
	}

	public List<String> getjercy7() {
		// TODO Auto-generated method stub
		return cd.getjercy7();
	}

	public List<String> getAusPlayerifAllrounder() {
		// TODO Auto-generated method stub
		return cd.getAusPlayerifAllrounder();
	}

	public List<cricketEntityBean> getAboveLimiOfRunObj(int a, int b) {
		// TODO Auto-generated method stub
		return cd.getAboveLimiOfRunObj(a, b);
	}

	public List<String> getIndianBatsmanNameDesc() {
		// TODO Auto-generated method stub
		return cd.getIndianBatsmanNameDesc();
	}

	public Integer secondMaximumRun() {
		// TODO Auto-generated method stub
		return cd.secondMaximumRun();
	}

	public Integer getIndianRightHandBatsmanMinimumRun() {
		return cd.getIndianRightHandBatsmanMinimumRun();
	}

	public String updateplayerscountry(int n, cricketEntityBean c) {
		// TODO Auto-generated method stub
		return cd.updateplayerscountry(n, c);
	}

	public List<cricketEntityBean> getCountry(String a) throws CountryNotFoundException {
		// TODO Auto-generated method stub
		if (cd.getCountry(a).isEmpty()) {
			throw new CountryNotFoundException("This country is not available");
		} else {
			return cd.getCountry(a);
		}
	}

	

	public List<cricketEntityBean> getTop3MaximumRun() {
		// TODO Auto-generated method stub
		List<cricketEntityBean> x=cr.findAll();
		
		List<cricketEntityBean> y = x.stream()
				.sorted(Comparator.comparingInt(cricketEntityBean::getRuns).reversed())
			    .limit(3)
			    .toList();
		
		return y;
		
	}

	public List<cricketEntityBean> getTop3Bowler() {
		// TODO Auto-generated method stub
		return cd.getTop3Bowler();
	}
	
	public List<cricketEntityBean> getUser(String a)  {
		// TODO Auto-generated method stub
		 List<cricketEntityBean> result = cd.getUser(a); 
		if (getUser(a).isEmpty()) {
			throw new NoSuchElementException("user ID not found Exception");
		} else {
			return result; 
		}
	}

	public List<cricketEntityBean> getRole(String a) throws RoleNotFoundException {
		// TODO Auto-generated method stub
		if(cd.getRole(a).isEmpty()) {
			throw new RoleNotFoundException("role is not available") ;
		}
		
		else {
			return cd.getRole(a); 
		}
	}
	
	public List<cricketEntityBean> getRoles(String a) throws RoleNotFoundException {
		// TODO Auto-generated method stub
		if(cd.getRole(a).isEmpty()) {
			throw new RoleNotFoundException("role is not available") ;
		}
		
		else {
			return cd.getRoles(a); 
		}
	}

	public List<cricketEntityBean> secondMaximumRunObjDetails() {
		// TODO Auto-generated method stub
		List<cricketEntityBean> x= cr.findAll();
		
		List<cricketEntityBean> y=x.stream()
				.sorted(Comparator.comparingInt(cricketEntityBean::getRuns).reversed())
				.skip(1)
				.limit(1)
				.toList();
		return y;
		
	
	}



	public cricketEntityBean getByid(int a) {
		// TODO Auto-generated method stub
		return cd.getByid(a);
	}
	
	

}
