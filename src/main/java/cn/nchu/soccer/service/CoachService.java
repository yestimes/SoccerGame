package cn.nchu.soccer.service;

import cn.nchu.soccer.model.*;
import cn.nchu.soccer.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CoachService {
	private Coach coach;
	
	@Autowired
	CoachRepository coachrepository;
	public Coach checkLogin(String username, String password){
		return coachrepository.checkLogin(username, password);
	}
	public void updateCoach(Coach coach, int id){
		coachrepository.updateCoach(coach, id);
	}
	public String findAudiecneById(int id){
		return coachrepository.findNameById(id);
	}
	
	@Autowired
	PlayerRepository playerrepository;
	public List<Player> goalBoard() {
		return playerrepository.goalBoard();
	}
	public List<Player> secBoard() {
		return playerrepository.secBoard();
	}
	
	
	@Autowired
	NewsRepository newsrepository;
	public List<News> findAllNews() {
		return newsrepository.findAll();
	}
	
	@Autowired
	TeamRepository teamrepository;
	public List<Team> teamBoard() {
		return teamrepository.teamBoard(); 
	}
	public String findTeamById(int id){
		return teamrepository.findNameById(id);
	}
	
	@Autowired
	MatchRepository matchrepository;
	public List<Match> findAllMatch() {
		return matchrepository.findAll(); 
	}
	


	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}
	
	
}
