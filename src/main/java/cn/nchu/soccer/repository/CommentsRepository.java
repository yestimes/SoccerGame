package cn.nchu.soccer.repository;

import cn.nchu.soccer.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository("CommentsRepository")
public class CommentsRepository  {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Comments> findAll() {
		String sql = "select * from t_comments";	
		RowMapper<Comments> rowMapper = new BeanPropertyRowMapper<>(Comments.class);  
		return jdbcTemplate.query(sql,rowMapper); 
	}
	public List<Comments> findByAudnence(int audienceId, int page) {
		String sql = "select * from t_comments where audienceId= ? limit ?,5";	
		RowMapper<Comments> rowMapper = new BeanPropertyRowMapper<>(Comments.class);  
		return jdbcTemplate.query(sql,rowMapper,audienceId, (page-1)*5); 
	}
	public List<Comments> findByMatch(int matchId, int page) {
		String sql = "select * from t_comments where matchId= ? limit ?,5";	
		RowMapper<Comments> rowMapper = new BeanPropertyRowMapper<>(Comments.class);  
		return jdbcTemplate.query(sql,rowMapper,matchId, (page-1)*5); 
	}
	public List<Comments> findByPage(int page){
		String sql = "select * from t_comments limit ?, 5";
		RowMapper<Comments> rowMapper = new BeanPropertyRowMapper<>(Comments.class);
		return jdbcTemplate.query(sql, rowMapper, (page-1)*5);
	}
	public List<Comments> findByKey(String key, int page){
		String sql = "select * from t_comments where content like ? limit ?, 5";
		RowMapper<Comments> rowMapper = new BeanPropertyRowMapper<>(Comments.class);
		return jdbcTemplate.query(sql, rowMapper, "%"+key+"%", (page-1)*5);
	}
	
	public void addComments(Comments comments){
		String sql = "insert into t_comments values(?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, getMaxInt()+1, comments.getAudienceId(), comments.getMatchId(), comments.getContent(), comments.getTime());
	}
	
	public void deleteComments(int id){
		String sql = "delete from t_comments where id = ?";
		jdbcTemplate.update(sql, id);
	}
	
	public int countAudienceComments(int id){
		String sql = "select IFNULL(count(id), 0) FROM t_comments where audienceId = ?"; 
		return jdbcTemplate.queryForObject(sql, Integer.class, id);
	}
	
	public int getMaxInt(){
		String sql = "select IFNULL(MAX(id), 0) from t_comments";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
}