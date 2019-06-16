package cn.nchu.soccer.repository;

import cn.nchu.soccer.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("AdminRepository")
public class AdminRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Admin> findAll() {
		String sql = "select * from t_admin";	
		RowMapper<Admin> rowMapper = new BeanPropertyRowMapper<>(Admin.class);  
		return jdbcTemplate.query(sql,rowMapper); 
	}
	public Admin checkLogin(String username, String password){
		String sql = "select * from t_admin where username=? and password=?";
		RowMapper<Admin> rowMapper = new BeanPropertyRowMapper<>(Admin.class);
		
		List<Admin> list = jdbcTemplate.query(sql,rowMapper, username, password);
		if(list.size()>0){
			//System.out.println(username);
			return list.get(0);
		}
		return null;
	}
	public void updateAdmin(Admin admin, int id){
		String sql = "update t_admin set username=?, tel=? where id=?";
		jdbcTemplate.update(sql, admin.getUsername(), admin.getTel(), id);
	}
	
}
