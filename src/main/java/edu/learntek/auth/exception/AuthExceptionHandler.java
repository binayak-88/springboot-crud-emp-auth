/**
 * 
 */
package edu.learntek.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author ADMIN
 *
 */
@ControllerAdvice
public class AuthExceptionHandler {

		@ExceptionHandler(AuthException.class)
		public ResponseEntity<String> handleAuthException(AuthException ae){
			ResponseEntity<String> res = new ResponseEntity<String>(ae.getMessage(),HttpStatus.UNAUTHORIZED);
			return res;
		}
}
