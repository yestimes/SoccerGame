package cn.nchu.soccer.service;

import cn.nchu.soccer.model.*;
import cn.nchu.soccer.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
	private Admin admin;
	private int page=0;
	
	@Autowired
	NewsRepository newsrepository;
	public List<News> findAllNews() {
		return newsrepository.findAll();
	}
	
	@Autowired
	AdminRepository adminrepository;
	public Admin checkLogin(String username, String password){
		return adminrepository.checkLogin(username, password);
	}
	public void updateAdmin(Admin admin, int id){
		adminrepository.updateAdmin(admin, id);
	}
	
	@Autowired
	CommentsRepository commentsrepository;
	
	public List<Comments> findAllComments() {
		return commentsrepository.findAll();
	}
	public void deleteComments(int id){
		commentsrepository.deleteComments(id);
	}
	public List<Comments> findCommentsMatch(int matchId) {
		return commentsrepository.findByMatch(matchId, 1); 
	}
	public int countAudienceComments(int id){
		return commentsrepository.countAudienceComments(id);
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
	PlayerRepository playerrepository;
	public List<Player> goalBoard() {
		return playerrepository.goalBoard();
	}
	public List<Player> secBoard() {
		return playerrepository.secBoard();
	}
	
	@Autowired
	MatchRepository matchrepository;
	public List<Match> findAllMatch() {
		return matchrepository.findAll(); 
	}
	public Match presentMatch(){
		return matchrepository.presentMatch();
	}
	public void addScore(int matchId, int team){
		matchrepository.addScore(matchId, team);
	}
	public void endMatch(int matchId){
		matchrepository.endMatch(matchId);
	}
	public void addMatch(Match match){
		matchrepository.add(match);
	}
	
	@Autowired
	AudienceRepository audiencerepository;
	public String findAudienceById(int id){
		return audiencerepository.findNameById(id);
	}
	public List<Audience> findAllAudience(){
		return audiencerepository.findAll();
	}
	
	@Autowired
	CoachRepository coachrepository;
	public List<Coach> findAllCoach(){
		return coachrepository.findAll();
	}
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
}
