/**
 * 
 */
package edu.learntek.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.learntek.auth.model.MyUserDeatils;
import edu.learntek.auth.service.MyAuthService;

/**
 * @author ADMIN
 *
 */
@RestController
public class AuthController {
	
	@Autowired
	private MyAuthService authService;
	
	@PostMapping("/auth")
	public ResponseEntity<String> isAuthenticated(@RequestBody MyUserDeatils myUserDeatils){
		boolean isAuth = authService.isAuthenticated(myUserDeatils.getUsername(), myUserDeatils.getPassword());
		
		if(isAuth)
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		else {
			return new ResponseEntity<String>("FAILURE", HttpStatus.UNAUTHORIZED);
		}
	}
}
