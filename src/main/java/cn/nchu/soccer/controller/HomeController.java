package cn.nchu.soccer.controller;

import cn.nchu.soccer.entity.viewObject.UserVO;
import cn.nchu.soccer.model.Admin;
import cn.nchu.soccer.model.Audience;
import cn.nchu.soccer.model.Coach;
import cn.nchu.soccer.model.Player;
import cn.nchu.soccer.service.AdminService;
import cn.nchu.soccer.service.AudienceService;
import cn.nchu.soccer.service.CoachService;
import cn.nchu.soccer.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

	@Autowired
	private
	AudienceService audienceservice;
	@Autowired
	private
	PlayerService playerservice;
	@Autowired
	private
	CoachService coachservice;
	@Autowired
	private
	AdminService adminservice;
	
//	@RequestMapping("/login")
	public String login(UserVO userbean) {
		if(userbean.getType() == 0 || userbean.getUsername()==null){									//阻止直接进入“/login”空指针报错
			model.addAttribute("prompt", "尚未登录");
			return "index";
		}
		if(type.equals("1")) {
			if(audienceservice.getAudience()!=null){		//已登录直接进入界面
				model.addAttribute("audience", audienceservice.getAudience());
				return "audience/c_audience";
			}
			Audience audience = audienceservice.checkLogin(username, password);		//验证登录信息
			if(audience!=null){														//信息正确
				System.out.println(audience.getUsername()+"登录");
				model.addAttribute("audience", audience);
				audienceservice.setAudience(audience);
				return "audience/c_audience";
			}
			model.addAttribute("prompt", "用户名或密码错误");							//信息错误
			return "index";
		}else if(type.equals("2")){
/*			if(playerservice.getPlayer()!=null){		//已登录直接进入界面
				model.addAttribute("player", playerservice.getPlayer());
				return "player/c_player_news";
			}
*/			Player player = playerservice.checkLogin(username, password);		//验证登录信息
			if(player!=null){														//信息正确
				System.out.println(player.getUsername()+"登录");
				model.addAttribute("player", player);
				playerservice.setPlayer(player);
				return "player/c_player_news";
			}
			model.addAttribute("prompt", "用户名或密码错误");							//信息错误
			return "index";
		}else if(type.equals("3")){
	/*		if(coachservice.getCoach()!=null){		//已登录直接进入界面
				model.addAttribute("coach", coachservice.getCoach());
				return "coach/c_coach";
			}
	*/		Coach coach = coachservice.checkLogin(username, password);		//验证登录信息
			if(coach!=null){														//信息正确
				System.out.println(coach.getUsername()+"登录");
				model.addAttribute("coach", coach);
				coachservice.setCoach(coach);
				return "coach/c_coach";
			}
			model.addAttribute("prompt", "用户名或密码错误");							//信息错误
			return "index";
		}else if(type.equals("4")){
	/*		if(adminservice.getAdmin()!=null){		//已登录直接进入界面
				model.addAttribute("admin", adminservice.getAdmin());
				return "admin/c_admin";
			}
	*/		Admin admin = adminservice.checkLogin(username, password);		//验证登录信息
			if(admin!=null){														//信息正确
				System.out.println(admin.getUsername()+"登录");
				model.addAttribute("admin", admin);
				adminservice.setAdmin(admin);
				return "admin/c_admin";
			}
			model.addAttribute("prompt", "用户名或密码错误");							//信息错误
			return "index";
		}
		else
			return "index";
	}
	@RequestMapping("/register")
	public String register(){
		return "register";
	}
}
