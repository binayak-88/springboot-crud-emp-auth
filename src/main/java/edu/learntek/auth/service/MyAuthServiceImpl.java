/**
 * 
 */
package edu.learntek.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.learntek.auth.dao.AuthDAO;
import edu.learntek.auth.exception.AuthException;

/**
 * @author ADMIN
 *
 */
@Service
public class MyAuthServiceImpl implements MyAuthService {
	
	@Autowired
	private AuthDAO authDAO;

	@Override
	public boolean isAuthenticated(String userid, String password) throws AuthException {
		// TODO Auto-generated method stub
		return authDAO.isAuthenticated(userid, password);
	}

}
