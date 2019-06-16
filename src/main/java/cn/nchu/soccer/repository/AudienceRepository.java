package cn.nchu.soccer.repository;

import cn.nchu.soccer.model.Audience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AudienceRepository")
public class AudienceRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Audience> findAll() {
		String sql = "select * from t_audience";	
		RowMapper<Audience> rowMapper = new BeanPropertyRowMapper<>(Audience.class);  
		return jdbcTemplate.query(sql,rowMapper); 
	}
	public Audience checkLogin(String username, String password){
		String sql = "select * from t_audience where username=? and password=?";
		RowMapper<Audience> rowMapper = new BeanPropertyRowMapper<>(Audience.class);
		
		List<Audience> list = jdbcTemplate.query(sql,rowMapper, username, password);
		if(list.size()>0){
			//System.out.println(username);
			return list.get(0);
		}
		return null;
	}
	public void updateAudience(Audience audience, int id){
		String sql = "update t_audience set username=?, tel=? where id=?";
		jdbcTemplate.update(sql, audience.getUsername(), audience.getTel(), id);
	}
	
	public String findNameById(int id) {
		String sql = "select username from t_audience where id= ?";	 
		return jdbcTemplate.queryForObject(sql, String.class, id);
	}
}
