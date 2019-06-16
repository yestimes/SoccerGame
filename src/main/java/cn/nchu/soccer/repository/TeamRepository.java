package cn.nchu.soccer.repository;

import cn.nchu.soccer.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("TeamRepository")
public class TeamRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<Team> teamBoard() {
		String sql = "select * from team_score";	
		RowMapper<Team> rowMapper = new BeanPropertyRowMapper<>(Team.class);  
		return jdbcTemplate.query(sql,rowMapper); 
	}
	
	public String findNameById(int id) {
		String sql = "select name from t_team where id= ?";	 
		return jdbcTemplate.queryForObject(sql, String.class, id);
	}
	
	public void updateTeam(Team team, int id){
		String sql = "update t_team set name=? where id=?";
		jdbcTemplate.update(sql, team.getName(), id);
	}
}
