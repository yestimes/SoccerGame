package cn.nchu.soccer.service;

import cn.nchu.soccer.model.*;
import cn.nchu.soccer.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AudienceService {
	
	private Audience audience;
	private int page = 1;
	
	@Autowired
	NewsRepository newsrepository;
	public List<News> findAllNews() {
		return newsrepository.findAll();
	}
	
	@Autowired
	AudienceRepository audiencerepository;
	public Audience checkLogin(String username, String password){
		return audiencerepository.checkLogin(username, password);
	}
	public void updateAudience(Audience audience, int id){
		audiencerepository.updateAudience(audience, id);
	}
	public String findAudienceById(int id){
		return audiencerepository.findNameById(id);
	}
	
	@Autowired
	CommentsRepository commentsrepository;
	public List<Comments> findCommentsAudnence(int audienceId, int page) {
		return commentsrepository.findByAudnence(audienceId, page); 
	}
	public void deleteComments(int id){
		commentsrepository.deleteComments(id);
	}
	public List<Comments> findCommentsMatch(int matchId, int page) {
		return commentsrepository.findByMatch(matchId, page); 
	}
	public List<Comments> findCommentsKey(String key, int page){
		return commentsrepository.findByKey(key, page);
	}
	public void addComments(Comments comments){
		commentsrepository.addComments(comments);
	}
	public List<Comments> findCommentsPage(int page){
		return commentsrepository.findByPage(page);
	}
	public int countAudienceComments(int id){
		return commentsrepository.countAudienceComments(id);
	}
	public int getMaxInt(){
		return commentsrepository.getMaxInt();
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
	
	public Audience getAudience() {
		return audience;
	}
	public void setAudience(Audience audience) {
		this.audience = audience;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
}
