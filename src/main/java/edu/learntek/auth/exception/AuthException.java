/**
 * 
 */
package edu.learntek.auth.exception;

/**
 * @author ADMIN
 *
 */
public class AuthException extends RuntimeException {
	private String msg;
	public AuthException(String msg) {
		super(msg);
		this.msg = msg;
	}
	public String getMessage() {
		return msg;
	}
}
