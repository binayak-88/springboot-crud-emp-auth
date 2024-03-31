/**
 * 
 */
package edu.learntek.auth.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import edu.learntek.auth.exception.AuthException;
import edu.learntek.auth.model.MyUserDeatils;

/**
 * @author ADMIN
 *
 */
@Repository
public class AuthDAOImpl implements AuthDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	

	@Override
	public boolean isAuthenticated(String userid, String password) {
		// TODO Auto-generated method stub
		boolean isAuthenticated = false;
		try {
			MyUserDeatils myUserDeatils = jdbcTemplate.queryForObject("select * from user_details where userid=? and password=?", new RowMapper<MyUserDeatils>() {
			
			@Override
			public MyUserDeatils mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				MyUserDeatils myUserDeatils = new MyUserDeatils();
				myUserDeatils.setUsername(rs.getString(1));
				myUserDeatils.setPassword(rs.getString(2));
				
				return myUserDeatils;
			}			
		}, new Object[] {userid,password});
		
		if(myUserDeatils!=null) {
			isAuthenticated = true;
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			throw new AuthException("userid and password not correct.............");
		}
		return isAuthenticated;
	}

}
