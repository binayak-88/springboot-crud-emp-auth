/**
 * 
 */
package edu.learntek.auth.dao;

/**
 * @author ADMIN
 *
 */
public interface AuthDAO {
	public boolean isAuthenticated(String userid, String password);
}
