package cn.nchu.soccer.repository;

import cn.nchu.soccer.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository("MatchRepository")
public class MatchRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<Match> findAll() {
		String sql = "select * from t_match where state= 1";	
		RowMapper<Match> rowMapper = new BeanPropertyRowMapper<>(Match.class);  
		return jdbcTemplate.query(sql,rowMapper); 
	}
	public Match presentMatch() {
		String sql = "select * from t_match where state= 0";	
		RowMapper<Match> rowMapper = new BeanPropertyRowMapper<>(Match.class);
		List<Match> list = jdbcTemplate.query(sql, rowMapper);
		if(list.size()>0)
			return jdbcTemplate.query(sql, rowMapper).get(0);
		else return null;
	}
	
	public void updateMatch(Match match, int id){
		String sql = "update t_match set in1=?, in2=?, spendTime=? where id=?";
		jdbcTemplate.update(sql, match.getIn1(), match.getIn2(), match.getSpendTime(), id);
	}
	public void add(Match match){
		String sql = "insert into t_match values(?, ?, ?, ?, ?, ?, ?, ?)"; 
		jdbcTemplate.update(sql, getMaxInt()+1, match.getTeam1(), match.getTeam2(), 0, 0, match.getStartTime(), 0, 0);
	}
	
	public void addScore(int matchId, int team){
		String sql = "";
		if(team==1)
			sql = "update t_match set in1 = in1+1 where id = ?";
		else
			sql = "update t_match set in2 = in2+1 where id = ?";
		jdbcTemplate.update(sql, matchId);
	}
	public void endMatch(int matchId){
		String sql = "update t_match set state = 1 where id = ?";
		jdbcTemplate.update(sql, matchId);
	}
	
	public int getMaxInt(){
		String sql = "select MAX(id) from t_match";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
}
