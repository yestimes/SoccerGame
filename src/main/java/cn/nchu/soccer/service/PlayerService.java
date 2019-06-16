package cn.nchu.soccer.service;

import cn.nchu.soccer.model.Match;
import cn.nchu.soccer.model.News;
import cn.nchu.soccer.model.Player;
import cn.nchu.soccer.model.Team;
import cn.nchu.soccer.repository.MatchRepository;
import cn.nchu.soccer.repository.NewsRepository;
import cn.nchu.soccer.repository.PlayerRepository;
import cn.nchu.soccer.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PlayerService {
	private Player player;
	
	@Autowired
	PlayerRepository playerrepository;
	public Player checkLogin(String username, String password){
		return playerrepository.checkLogin(username, password);
	}
	public void updatePlayer(Player player, int id){
		playerrepository.updatePlayer(player, id);
	}
	public String findAudiecneById(int id){
		return playerrepository.findNameById(id);
	}

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
	


	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
}
