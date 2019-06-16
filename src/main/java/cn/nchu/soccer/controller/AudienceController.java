package cn.nchu.soccer.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.nchu.soccer.model.*;
import cn.nchu.soccer.service.AudienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class AudienceController {
	
	@Autowired
	AudienceService audienceservice;
	
	@RequestMapping("/audience_logout")
	public String logout(){
		audienceservice.setAudience(null);
		return "index";
	}
	@RequestMapping("/c_audience_info")
	public String audienceInfo(Model model){
		if(audienceservice.getAudience()==null){		//是否已登录
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		model.addAttribute("audience", audienceservice.getAudience());
		model.addAttribute("id", audienceservice.getAudience().getId());
		model.addAttribute("username", audienceservice.getAudience().getUsername());
		model.addAttribute("tel", audienceservice.getAudience().getTel());
		return "audience/c_audience_info";
	}
	@RequestMapping("/updateAudience")
	public String updateAudience(Integer id, String username, String tel, Model model){
		if(audienceservice.getAudience()==null||username == null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		Audience audience = new Audience();
		audience.setId(id);
		audience.setUsername(username);
		audience.setTel(tel);
		model.addAttribute("audience", audienceservice.getAudience());
		audienceservice.updateAudience(audience, id);
		audienceservice.getAudience().setUsername(username);
		audienceservice.getAudience().setTel(tel);
		return audienceInfo(model);
	}
	
	@RequestMapping("/c_audience_news")
	public String c_audience_news(Model model){	//新闻列表
		if(audienceservice.getAudience()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		model.addAttribute("audience", audienceservice.getAudience());
		List<News> list = audienceservice.findAllNews();
		model.addAttribute("list", list);
		return "audience/c_audience_news";
	}
	
	@RequestMapping("/c_audience_comments")
	public String c_audience_comments(Model model, Integer page){
		if(audienceservice.getAudience()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		if(page == null) page = 1;
		audienceservice.setPage(page);
		model.addAttribute("audience", audienceservice.getAudience());
		List<Comments> list = audienceservice.findCommentsAudnence(audienceservice.getAudience().getId(), page);
		model.addAttribute("list", list);
		model.addAttribute("page",page);
		int count = audienceservice.countAudienceComments(audienceservice.getAudience().getId());
		model.addAttribute("count", count);
		model.addAttribute("maxPage",(count-1)/5+1);
		return "audience/c_audience_comments";
	}
	@RequestMapping("/deleteComments")
	public String deleteComments(Integer id,  Model model){
		if(audienceservice.getAudience()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		audienceservice.deleteComments(id);
		return c_audience_comments(model, 1);
	}
	
	@RequestMapping("/c_audience_scoreboard")
	public String c_audience_scoreboard(Model model){
		if(audienceservice.getAudience()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		model.addAttribute("audience", audienceservice.getAudience());
		List<Team> list1 = audienceservice.teamBoard();
		model.addAttribute("score", list1);
		List<Player> list2 = audienceservice.goalBoard();
		model.addAttribute("goal", list2);
		List<Player> list3 = audienceservice.secBoard();
		model.addAttribute("secAttack", list3);
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(Player player : list2){
			map.put(player.getTeamId(), audienceservice.findTeamById(player.getTeamId()));
		}
		model.addAttribute("map", map);
		return "audience/c_audience_scoreboard";
	}
	
	@RequestMapping("/c_audience_matchList")
	public String c_audience_matchList(Model model){
		if(audienceservice.getAudience()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		model.addAttribute("audience", audienceservice.getAudience());
		List<Match> list = audienceservice.findAllMatch();
		model.addAttribute("list", list);
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(Match match : list){
			map.put(match.getTeam1(), audienceservice.findTeamById(match.getTeam1()));
			map.put(match.getTeam2(), audienceservice.findTeamById(match.getTeam2()));
		}
		model.addAttribute("map", map);
		
		return "audience/c_audience_matchList";
	}
	@RequestMapping("/c_audience_presentMatch")
	public String c_audience_presentMatch(Model model, Integer page){
		if(audienceservice.getAudience()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		model.addAttribute("audience", audienceservice.getAudience());
		Match match = audienceservice.presentMatch();
		if(match == null){
			return "audience/c_audience_noMatch";
		}
		model.addAttribute("match", match);
		String team1 = audienceservice.findTeamById(match.getTeam1());
		String team2 = audienceservice.findTeamById(match.getTeam2());
		model.addAttribute("team1", team1);
		model.addAttribute("team2", team2);
		List<Comments> list = audienceservice.findCommentsMatch(match.getId(), page);
		for(Comments com : list){
			if(com.getContent().length()>10)
				com.setContent(com.getContent().substring(0, 9)+"……");
		}
		model.addAttribute("list", list);
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(Comments comments : list){
			map.put(comments.getAudienceId(), audienceservice.findAudienceById(comments.getAudienceId()));
		}
		model.addAttribute("map", map);
		return "audience/c_audience_presentMatch";
	}
	@RequestMapping("/addComments")
	public String addComments(String mycomments, Model model){
		if(audienceservice.getAudience()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		if(mycomments==null||mycomments.length() == 0){
			return c_audience_presentMatch(model, 1);
		}
		
		Comments comments = new Comments();
		comments.setAudienceId(audienceservice.getAudience().getId());
		comments.setMatchId(audienceservice.presentMatch().getId());
		comments.setContent(mycomments);
		Calendar cal=Calendar.getInstance(); 
		String date,day,month,year; 
		year =String.valueOf(cal.get(Calendar.YEAR));
		month =String.valueOf(cal.get(Calendar.MONTH)+1); 
		day =String.valueOf(cal.get(Calendar.DATE)); 
		date = year+"-"+month+"-"+day;
		comments.setTime(date);
		audienceservice.addComments(comments);
		return c_audience_presentMatch(model, 1);
	}
	@RequestMapping("/nextPageMatchComments")
	public String nextPageMatchComments(Model model){
		if(audienceservice.getAudience()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		audienceservice.setPage(audienceservice.getPage()+1);
		return c_audience_presentMatch(model, audienceservice.getPage());
	}
	@RequestMapping("/lastPageMatchComments")
	public String lastPageMatchComments(Model model){
		if(audienceservice.getAudience()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		int page = audienceservice.getPage();
		if(page>1)
			audienceservice.setPage(page-1);
		return c_audience_presentMatch(model, audienceservice.getPage());
	}
	@RequestMapping("/nextPageAudienceComments")
	public String nextPageAudienceComments(Model model){
		if(audienceservice.getAudience()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		audienceservice.setPage(audienceservice.getPage()+1);
		return c_audience_comments(model, audienceservice.getPage());
	}
	@RequestMapping("/lastPageAudienceComments")
	public String lastPageAudienceComments(Model model){
		if(audienceservice.getAudience()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		int page = audienceservice.getPage();
		if(page>1)
			audienceservice.setPage(page-1);
		return c_audience_comments(model, audienceservice.getPage());
	}
	@RequestMapping("/jumpAudienceComments")
	public String jumpAudienceComments(Model model, Integer page){
		if(audienceservice.getAudience()==null){		//未登录返回index界面
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		audienceservice.setPage(page);
		return c_audience_comments(model, page);
	}
	

}
