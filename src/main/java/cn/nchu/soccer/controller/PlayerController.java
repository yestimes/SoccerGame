package cn.nchu.soccer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.nchu.soccer.model.Match;
import cn.nchu.soccer.model.News;
import cn.nchu.soccer.model.Player;
import cn.nchu.soccer.model.Team;
import cn.nchu.soccer.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class PlayerController {
	@Autowired
	PlayerService playerservice;
	
	@RequestMapping("/player_logout")
	public String logout(){
		playerservice.setPlayer(null);
		return "index";
	}
	@RequestMapping("/c_player_info")
	public String PlayerInfo(Model model){
		if(playerservice.getPlayer()==null){		//是否已登录
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		model.addAttribute("player",playerservice.getPlayer());
		model.addAttribute("id", playerservice.getPlayer().getId());
		model.addAttribute("username", playerservice.getPlayer().getUsername());
		model.addAttribute("realname",playerservice.getPlayer().getRealname());
		model.addAttribute("tel", playerservice.getPlayer().getTel());
		return "player/c_player_info";
	}
	
	@RequestMapping("/updatePlayer")
	public String updatePlayer(int id, String username, String tel, String realname, Model model){
		if(playerservice.getPlayer()==null||username == null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		Player player = new Player();
		player.setId(id);
		player.setUsername(username);
		player.setRealname(realname);
		player.setTel(tel);
		model.addAttribute("player", playerservice.getPlayer());
		playerservice.getPlayer().setUsername(username);
		playerservice.getPlayer().setRealname(realname);
		playerservice.getPlayer().setTel(tel);
		playerservice.updatePlayer(player, id);
		System.out.println(username);
		return PlayerInfo(model);
	}
	
	@RequestMapping("/c_player_news")
	public String c_player_news(Model model){	//新闻列表
		if(playerservice.getPlayer()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		model.addAttribute("player", playerservice.getPlayer());
		List<News> list = playerservice.findAllNews();
		model.addAttribute("list", list);
		return "player/c_player_news";
	}
	
	
	
	@RequestMapping("/c_player_scoreboard")
	public String c_Player_scoreboard(Model model){
		if(playerservice.getPlayer()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		model.addAttribute("player", playerservice.getPlayer());
		List<Team> list1 = playerservice.teamBoard();
		model.addAttribute("score", list1);
		List<Player> list2 = playerservice.goalBoard();
		model.addAttribute("goal", list2);
		List<Player> list3 = playerservice.secBoard();
		model.addAttribute("secAttack", list3);
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(Player player : list2){
			map.put(player.getTeamId(), playerservice.findTeamById(player.getTeamId()));
		}
		model.addAttribute("map", map);
		return "player/c_player_scoreboard";
	}
	
	@RequestMapping("/c_player_matchList")
	public String c_Player_matchList(Model model){
		if(playerservice.getPlayer()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		model.addAttribute("player", playerservice.getPlayer());
		List<Match> list = playerservice.findAllMatch();
		model.addAttribute("list", list);
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(Match match : list){
			map.put(match.getTeam1(), playerservice.findTeamById(match.getTeam1()));
			map.put(match.getTeam2(), playerservice.findTeamById(match.getTeam2()));
		}
		model.addAttribute("map", map);
		
		return "player/c_player_matchList";
	}

}

