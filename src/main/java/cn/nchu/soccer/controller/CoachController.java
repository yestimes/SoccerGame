package cn.nchu.soccer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.nchu.soccer.model.*;
import cn.nchu.soccer.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class CoachController {
	@Autowired
	CoachService coachservice;

	@RequestMapping("/coach_logout")
	public String logout(){//注销
		coachservice.setCoach(null);
		return "index";
	}
	@RequestMapping("/c_coach_info")	
	public String CoachInfo(Model model){	//教练个人信息
		if(coachservice.getCoach()==null){		//是否已登录
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		model.addAttribute("coach",coachservice.getCoach());
		model.addAttribute("id", coachservice.getCoach().getId());
		model.addAttribute("username", coachservice.getCoach().getUsername());
		model.addAttribute("tel", coachservice.getCoach().getTel());
		return "coach/c_coach_info";
	}
	
	@RequestMapping("/updateCoach")
	public String updateCoach(int id, String username, String tel, Model model){	//修改教练信息
		if(coachservice.getCoach()==null||username == null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		Coach coach = new Coach();
		coach.setId(id);
		coach.setUsername(username);
		coach.setTel(tel);
		model.addAttribute("Coach", coachservice.getCoach());
		coachservice.updateCoach(coach, id);
		coachservice.getCoach().setUsername(username);
		coachservice.getCoach().setTel(tel);
		
		return CoachInfo(model);
	}
	
	@RequestMapping("/c_coach_news")
	public String c_coach_news(Model model){	//新闻列表
		if(coachservice.getCoach()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		model.addAttribute("Coach", coachservice.getCoach());
		List<News> list = coachservice.findAllNews();
		model.addAttribute("list", list);
		return "coach/c_coach_news";
	}
	
	@RequestMapping("/c_coach_matchList")
	public String c_coach_matchList(Model model){  //比赛列表
		if(coachservice.getCoach()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		model.addAttribute("Coach", coachservice.getCoach());
		List<Match> list = coachservice.findAllMatch();
		model.addAttribute("list", list);
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(Match match : list){
			map.put(match.getTeam1(), coachservice.findTeamById(match.getTeam1()));
			map.put(match.getTeam2(), coachservice.findTeamById(match.getTeam2()));
		}
		model.addAttribute("map", map);
		
		return "coach/c_coach_matchList";
	}
	
	@RequestMapping("/c_coach_scoreboard")
	public String c_coach_scoreboard(Model model){
		if(coachservice.getCoach()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		model.addAttribute("coach", coachservice.getCoach());
		List<Team> list1 = coachservice.teamBoard();
		model.addAttribute("score", list1);
		List<Player> list2 = coachservice.goalBoard();
		model.addAttribute("goal", list2);
		List<Player> list3 = coachservice.secBoard();
		model.addAttribute("secAttack", list3);
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(Player player : list2){
			map.put(player.getTeamId(), coachservice.findTeamById(player.getTeamId()));
		}
		model.addAttribute("map", map);
		return "coach/c_coach_scoreboard";
	}

}

