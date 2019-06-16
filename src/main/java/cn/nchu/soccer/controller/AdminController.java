package cn.nchu.soccer.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.nchu.soccer.model.*;
import cn.nchu.soccer.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AdminController {
	@Autowired
	AdminService adminservice;
	
	@RequestMapping("/admin_logout")
	public String logout(){
		adminservice.setAdmin(null);
		return "index";
	}
	@RequestMapping("/c_admin_info")
	public String adminInfo(Model model){
		if(adminservice.getAdmin()==null){		//是否已登录
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		model.addAttribute("admin", adminservice.getAdmin());
		model.addAttribute("id", adminservice.getAdmin().getId());
		model.addAttribute("username", adminservice.getAdmin().getUsername());
		model.addAttribute("tel", adminservice.getAdmin().getTel());
		return "admin/c_admin_info";
	}
	@RequestMapping("/updateAdmin")
	public String updateAdmin(int id, String username, String tel, Model model){
		if(adminservice.getAdmin()==null||username == null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		
		Admin admin = new Admin();
		admin.setId(id);
		admin.setUsername(username);
		admin.setTel(tel);
		model.addAttribute("admin", adminservice.getAdmin());
		adminservice.updateAdmin(admin, id);
		adminservice.getAdmin().setUsername(username);
		adminservice.getAdmin().setTel(tel);
		return adminInfo(model);
	}
	
	@RequestMapping("/c_admin_comments")
	public String c_admin_comments(Model model){
		if(adminservice.getAdmin()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		List<Comments> list = adminservice.findAllComments();
		model.addAttribute("list", list);
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(Comments comments : list){
			map.put(comments.getAudienceId(), adminservice.findAudienceById(comments.getAudienceId()));
		}
		model.addAttribute("map", map);
		model.addAttribute("admin", adminservice.getAdmin());
		return "admin/c_admin_comments";
	}
	@RequestMapping("/adminDeleteComments")
	public String adminDeleteComments(int id,  Model model){
		if(adminservice.getAdmin()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		adminservice.deleteComments(id);
		return c_admin_comments(model);
	}
	
/*	
	@RequestMapping("/c_admin_news")
	public String c_admin_news(Model model){	//新闻列表
		if(adminservice.getAdmin()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		model.addAttribute("admin", adminservice.getAdmin());
		List<News> list = adminservice.findAllNews();
		model.addAttribute("list", list);
		return "admin/c_admin_news";
	}
*/	
	@RequestMapping("/c_admin_scoreboard")
	public String c_admin_scoreboard(Model model){
		if(adminservice.getAdmin()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		model.addAttribute("admin", adminservice.getAdmin());
		List<Team> list1 = adminservice.teamBoard();
		model.addAttribute("score", list1);
		List<Player> list2 = adminservice.goalBoard();
		model.addAttribute("goal", list2);
		List<Player> list3 = adminservice.secBoard();
		model.addAttribute("secAttack", list3);
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(Player player : list2){
			map.put(player.getTeamId(), adminservice.findTeamById(player.getTeamId()));
		}
		model.addAttribute("map", map);
		return "admin/c_admin_scoreboard";
	}
	
	@RequestMapping("/c_admin_matchList")
	public String c_admin_matchList(Model model){
		if(adminservice.getAdmin()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		List<Match> list = adminservice.findAllMatch();
		model.addAttribute("list", list);
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(Match match : list){
			map.put(match.getTeam1(), adminservice.findTeamById(match.getTeam1()));
			map.put(match.getTeam2(), adminservice.findTeamById(match.getTeam2()));
		}
		model.addAttribute("map", map);
		model.addAttribute("admin", adminservice.getAdmin());
		return "admin/c_admin_matchList";
	}
	@RequestMapping("/c_admin_presentMatch")
	public String c_admin_presentMatch(Model model){
		if(adminservice.getAdmin()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		Match match = adminservice.presentMatch();
		if(match == null){
			model.addAttribute("admin", adminservice.getAdmin());
			List<Team> list = adminservice.teamBoard();
			model.addAttribute("list", list);
			Date date=new Date();    
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
			model.addAttribute("time", df.format(date));
			return "admin/c_admin_noMatch";
		}
		model.addAttribute("match", match);
		String team1 = adminservice.findTeamById(match.getTeam1());
		String team2 = adminservice.findTeamById(match.getTeam2());
		model.addAttribute("team1", team1);
		model.addAttribute("team2", team2);
		List<Comments> list = adminservice.findCommentsMatch(match.getId());
		model.addAttribute("list", list);
		for(Comments com : list){
			if(com.getContent().length()>20)
				com.setContent(com.getContent().substring(0, 18)+"……");
		}
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(Comments comments : list){
			map.put(comments.getAudienceId(), adminservice.findAudienceById(comments.getAudienceId()));
		}
		model.addAttribute("map", map);
		model.addAttribute("admin", adminservice.getAdmin());
		return "admin/c_admin_presentMatch";
	}
	@RequestMapping("/c_admin_addScore")
	public String c_admin_addScore(Model model, String matchId, String team){
		if(adminservice.getAdmin()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		adminservice.addScore(Integer.parseInt(matchId), Integer.parseInt(team));
		
		return c_admin_presentMatch(model);
	}
	@RequestMapping("/c_admin_endMatch")
	public String c_admin_endMatch(Model model, String matchId){
		if(adminservice.getAdmin()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		adminservice.endMatch(Integer.parseInt(matchId));
		return c_admin_presentMatch(model);
	}
	@RequestMapping("/c_admin_addMatch")
	public String c_admin_addMatch(Model model, int team1, int team2, String time){
		if(adminservice.getAdmin()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		Match match = new Match();
		match.setTeam1(team1);match.setTeam2(team2);match.setStartTime(time);
		adminservice.addMatch(match);
		return c_admin_presentMatch(model);
	}
	
	@RequestMapping("/c_admin_coachList")
	public String c_admin_coachList(Model model){
		if(adminservice.getAdmin()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		List<Coach> list = adminservice.findAllCoach();
		model.addAttribute("list", list);
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(Coach coach : list){
			map.put(coach.getTeamId(), adminservice.findTeamById(coach.getTeamId()));
		}
		model.addAttribute("map", map);
		model.addAttribute("admin", adminservice.getAdmin());
		return "admin/c_admin_coachList";
	}
	@RequestMapping("/c_admin_audienceList")
	public String c_admin_audienceList(Model model){
		if(adminservice.getAdmin()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		List<Audience> list = adminservice.findAllAudience();
		model.addAttribute("list", list);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(Audience audience : list){
			map.put(audience.getId(), adminservice.countAudienceComments(audience.getId()));
		}
		model.addAttribute("map", map);
		model.addAttribute("admin", adminservice.getAdmin());
		return "admin/c_admin_audienceList";
	}
}
