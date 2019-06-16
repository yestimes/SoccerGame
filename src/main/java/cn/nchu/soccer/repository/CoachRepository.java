package cn.nchu.soccer.repository;

import cn.nchu.soccer.model.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CoachRepository")
public class CoachRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Coach> findAll() {
		String sql = "select * from t_coach";	
		RowMapper<Coach> rowMapper = new BeanPropertyRowMapper<>(Coach.class);  
		return jdbcTemplate.query(sql,rowMapper); 
	}
	public Coach findById(int id) {
		String sql = "select * from t_coach where id= ?";	
		return jdbcTemplate.queryForObject(sql, Coach.class, id);
	}
	public Coach checkLogin(String username, String password){
		String sql = "select * from t_coach where username=? and password=?";
		RowMapper<Coach> rowMapper = new BeanPropertyRowMapper<>(Coach.class);
		
		List<Coach> list = jdbcTemplate.query(sql,rowMapper, username, password);
		if(list.size()>0){
			//System.out.println(username);
			return list.get(0);
		}
		return null;
	}
	public void updateCoach(Coach coach, int id){
		String sql = "update t_coach set username=?, tel=? where id=?";
		jdbcTemplate.update(sql, coach.getUsername(), coach.getTel(), id);
	}
	
	public String findNameById(int id) {
		String sql = "select realname from t_coach where id= ?";	
		return jdbcTemplate.queryForObject(sql, String.class, id);
	}
}
