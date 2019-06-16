package cn.nchu.soccer.repository;

import cn.nchu.soccer.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PlayerRepository")
public class PlayerRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Player> findAll() {
		String sql = "select * from t_player";	
		RowMapper<Player> rowMapper = new BeanPropertyRowMapper<>(Player.class);  
		return jdbcTemplate.query(sql,rowMapper); 
	}
	public Player findById(int id) {
		String sql = "select * from t_player where id= ?";	
		return jdbcTemplate.queryForObject(sql, Player.class);
	}
	
	public List<Player> goalBoard() {
		String sql = "select * from t_player order by goal desc";	
		RowMapper<Player> rowMapper = new BeanPropertyRowMapper<>(Player.class);  
		return jdbcTemplate.query(sql,rowMapper); 
	}
	public List<Player> secBoard() {
		String sql = "select * from t_player order by secattack desc";	
		RowMapper<Player> rowMapper = new BeanPropertyRowMapper<>(Player.class);  
		return jdbcTemplate.query(sql,rowMapper); 
	}
	
	public Player checkLogin(String username, String password){
		String sql = "select * from t_player where username=? and password=?";
		RowMapper<Player> rowMapper = new BeanPropertyRowMapper<>(Player.class);
		
		List<Player> list = jdbcTemplate.query(sql,rowMapper, username, password);
		if(list.size()>0){
			//System.out.println(username);
			return list.get(0);
		}
		return null;
	}
	public void updatePlayer(Player player, int id){
		String sql = "update t_player set username=?, realname=?, tel=? where id=?";
		jdbcTemplate.update(sql, player.getUsername(), player.getRealname(), player.getTel(), id);
	}
	
	public String findNameById(int id) {
		String sql = "select username from t_player where id= ?";	
		return jdbcTemplate.queryForObject(sql, String.class);
	}
}
