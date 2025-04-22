package com.cricket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cricket.entity.cricketEntityBean;


public interface cricketRepository extends JpaRepository<cricketEntityBean, Integer> {

	
	@Query(value="select * from player_details where team=?;", nativeQuery=true)
	List<cricketEntityBean> getTeam(String team);

	@Query(value="select*from player_details where player_name =?;", nativeQuery=true)
	List<cricketEntityBean> getPlayer(String a);

	
	@Query(value="select *from player_details where team=?;", nativeQuery=true)
	List<cricketEntityBean> getCaptainList(String a);

	
	@Query(value = "SELECT * FROM player_details WHERE runs = (SELECT MAX(runs) FROM player_details)", nativeQuery = true)
	cricketEntityBean getMaxRunPersonObj();

	@Query(value = "SELECT player_name FROM player_details WHERE jersey_number = 17;", nativeQuery = true)
	List<String> getjercy7();

	@Query(value="Select player_name from player_details Where country ='AUSTRALIA' and role= 'All-Rounder' ;", nativeQuery=true) 
	List<String> getAusPlayerifAllrounder();

	@Query(value = "SELECT * FROM player_details WHERE runs > :a AND runs < :b", nativeQuery = true)
	List<cricketEntityBean> getAboveLimitOfRunObj(@Param("a") int a, @Param("b") int b);

	@Query(value = "SELECT player_name FROM player_details WHERE country = 'INDIA' AND role = 'Batsman' ORDER BY player_name DESC", nativeQuery = true)
	List<String> getIndianBatsmanNameDesc();

	
	@Query(value = "SELECT MAX(runs) FROM player_details WHERE runs < (SELECT MAX(runs) FROM player_details)", nativeQuery = true)
	Integer secondMaximumRun();

	

	@Query(value = "SELECT MIN(runs) FROM player_details WHERE runs > (SELECT MIN(runs) FROM player_details WHERE country = 'INDIA' AND batting_style = 'Right-Hand Batsman')", nativeQuery = true)
	Integer getIndianRightHandBatsmanMinimumRun();

	
	@Query(value="select * from player_details where Country=?;", nativeQuery=true)
	List<cricketEntityBean> getCountry(String a);

	
	@Query(value="select * from player_details where player_name=?;", nativeQuery=true)
	List<cricketEntityBean> getUser(String a);

	
	@Query(value = "SELECT * FROM player_details ORDER BY wickets DESC LIMIT 3", nativeQuery = true)
	List<cricketEntityBean> getTop3Bowler();

	@Query(value="select * from player_details where role=?;", nativeQuery=true)
	List<cricketEntityBean> getRole(String a);

	
	@Query(value="select * from player_details where role=?;", nativeQuery=true)
	List<cricketEntityBean> getRoles(String a);

	
	
	
	

}
