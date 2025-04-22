package com.cricket.controller;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cricket.ExceptionHandler.CountryNotFoundException;
import com.cricket.ExceptionHandler.PlayerNotFoundException;
import com.cricket.ExceptionHandler.RoleNotFoundException;
import com.cricket.ExceptionHandler.TeamNotFoundException;
import com.cricket.entity.cricketEntityBean;
import com.cricket.service.cricketService;

@RestController
public class cricketController {

    @Autowired
    cricketService cs;
    
    @PostMapping(value="/postListOfObject")
    public String postListOfObject(@RequestBody List<cricketEntityBean> c) {
    	return cs.postListOfObject(c);
    }
    
    @GetMapping(value="/getByid/{a}")
    public cricketEntityBean getByid(@PathVariable int a) {
    	return cs.getByid(a);
    } 
     
    
    @GetMapping(value="/getMaxRunPersonObj")
    public cricketEntityBean getMaxRunPersonObj(cricketEntityBean c) {
    	return cs.getMaxRunPersonObj();
    }
    
    @GetMapping(value="/getListofObject")
    public List<cricketEntityBean> getListofObject() {
    	return cs.getListofObject();
    }
    
    @GetMapping(value="/getjercyseven")
    public List<String> getjercy7 () {
    	return cs.getjercy7();
    }
    
    
    @GetMapping(value="/getAusPlayerifAllrounder")
    public List<String> getAusPlayerifAllrounder() {
    	return cs.getAusPlayerifAllrounder() ;
    }
    
    
    @GetMapping(value="/getAboveLimiOfRunObj/{a}/{b}")
    public List<cricketEntityBean> getAboveLimiOfRunObj(@PathVariable int a, @PathVariable int b) {
    	return cs.getAboveLimiOfRunObj(a,b);
    }
    
    @GetMapping(value="/getIndianBatsmanNameDesc")
    public List<String> getIndianBatsmanNameDesc() {
    	return cs.getIndianBatsmanNameDesc();
    }
    
    @GetMapping(value="/secondMaximumRun")
    public Integer secondMaximumRun() {
    	return cs.secondMaximumRun();
    }
    
    @GetMapping(value="/getIndianRightHandBatsmanMinimumRun")
    public Integer getIndianRightHandBatsmanMinimumRun() {
    	return cs.getIndianRightHandBatsmanMinimumRun();
    }
    
    
     
    
    @PutMapping(value="/updateobjects/{n}")
    public String updateobjects(@PathVariable int n,@RequestBody cricketEntityBean c) {
    	return cs.updateobjects(n,c) ;
    }
    
    @PatchMapping(value="/patchsinglefield/{n}")
    public String patchsinglefield(@PathVariable int n, @RequestBody cricketEntityBean c) {
    	return cs.patchsinglefield(n,c) ;
    }
    
    
    @GetMapping(value="/getmaximumRun")
    public cricketEntityBean getmaximumRun(@RequestBody cricketEntityBean c) {
    	return cs.getmaximumRun(c) ;
    }
    
    
    
    @GetMapping(value="/secondMaximumRunObjDetails")
    public List<cricketEntityBean> secondMaximumRunObjDetails() {
    	return cs.secondMaximumRunObjDetails();
    	
    }
    
    
    @GetMapping(value="/getmaximumrunonly")
    public Integer getmaximumrunonly(@RequestBody cricketEntityBean c) {
		return cs.getmaximumrunonly(c);
    	
    }
    
    @GetMapping(value="/getIndianPlayerOnly")
    public List<cricketEntityBean> getIndianPlayerOnly(@RequestBody cricketEntityBean c) {
    	return cs.getIndianPlayerOnly(c);
    }
    
    
    @GetMapping(value="/getJercyNo7")
    public List<cricketEntityBean> getJercyNo7(@RequestBody cricketEntityBean c) {
    	return cs.getJercyNo7(c) ;
    }
    
    @GetMapping(value="/Australinaplayernameifallground") 
    public List<String> Australinaplayernameifallground(@RequestBody cricketEntityBean c){
    	return cs.Australinaplayernameifallground(c);
    }
    
    @GetMapping(value="/getAboverangeofRun/{a}/{b}")
    public List<String> getAboverangeofRun(@PathVariable int a, @PathVariable int b,
    		@RequestBody cricketEntityBean c) {
    	return cs.getAboverangeofRun(a,b,c);
    }
    
    @GetMapping(value="/getIndianPlayerBatsmanOnly")
    public List<cricketEntityBean> getIndianPlayerBatsmanOnly(@RequestBody cricketEntityBean c) {
    	return cs.getIndianPlayerBatsmanOnly(c);
    }
    
    @GetMapping(value="/getIndianPlayerscountRightHand")
    public long getIndianPlayerscountRightHand(cricketEntityBean c) {
    
    return cs.getIndianPlayerscountRightHand(c);
    
    }
    
    @GetMapping(value="/getIndianPlayersRunstotal")
    public Integer getIndianPlayersRunstotal(@RequestBody cricketEntityBean c) {
		return cs.getIndianPlayersRunstotal(c);
    	
    }
    
    @GetMapping(value="/getSecondMaximumRuns")
    public Integer getSecondMaximumRuns(@RequestBody cricketEntityBean c) {
    	return cs.getSecondMaximumRuns(c);
    }
    
    
    @GetMapping(value="/getSecondMinimumRuns")
    public Integer getSecondMinimumRuns(@RequestBody cricketEntityBean c) {
    	return cs.getSecondMinimumRuns(c);
    }
    
    
    @GetMapping(value="/getgroupbyindianplayers")
    public Map<String, Long> getgroupbyindianplayers(@RequestBody cricketEntityBean c) {
		return cs.getgroupbyindianplayers(c);
    	
    }
    
    @GetMapping(value="/getAscPlayerName") 
    public List<String> getAscPlayerName(@RequestBody cricketEntityBean c) {
    	return cs.getAscPlayerName(c);
    }
    
    @GetMapping(value="/getDescPlayerName") 
    public List<String> getDescPlayerName(@RequestBody cricketEntityBean c) {
    	return cs.getDescPlayerName(c);
    }
    
    @GetMapping(value="/getIndianPlayerlefthandbatsmanGroupby")
    public Map<String, Long> getIndianPlayerlefthandbatsmanGroupby(@RequestBody cricketEntityBean c) {
    	return cs.getIndianPlayerlefthandbatsmanGroupby();
    }
    
    
    @GetMapping(value="/getTeam/{team}")
    public List<cricketEntityBean> getTeam(@PathVariable String team) throws TeamNotFoundException {
		return cs.getTeam(team);
    	
    }
    
    @GetMapping(value="/getPlayer/{a}")
    public List<cricketEntityBean> getPlayer(@PathVariable String a) throws PlayerNotFoundException {
    	return cs.getPlayer(a);
    }
    
    @PutMapping(value="/updateplayerscountry/{n}")
    public String updateplayerscountry(@PathVariable int n, @RequestBody cricketEntityBean c) {
		return cs.updateplayerscountry(n, c);
    	
    }
    
    
    @GetMapping(value="/getCountry/{a}") 
    public List<cricketEntityBean> getCountry(@PathVariable String a) throws CountryNotFoundException {
		return cs.getCountry(a);
    	
    }
    
  
    
    @GetMapping(value="/getTop3MaximumRun")
    public List<cricketEntityBean> getTop3MaximumRun() {
    	return cs.getTop3MaximumRun();
    }
    
    
    @GetMapping("/getTop3Bowler")
    public List<cricketEntityBean> getTop3Bowler() {
    	return cs.getTop3Bowler();
    }
    
    @GetMapping(value="/getUser/{a}")
    public List<cricketEntityBean> getUser(@PathVariable String a) {
    	return cs.getUser(a);
    }
    
    @GetMapping(value="/getRole/{a}")
    public List<cricketEntityBean> getRole(@PathVariable String a) throws RoleNotFoundException {
		return cs.getRole(a); 
    	  
    }
    
    @GetMapping(value="/getRoles/{a}")
    public List<cricketEntityBean> getRoles(@PathVariable String a) throws RoleNotFoundException {
		return cs.getRole(a); 
    	  
    }
      
    
    
    
}
