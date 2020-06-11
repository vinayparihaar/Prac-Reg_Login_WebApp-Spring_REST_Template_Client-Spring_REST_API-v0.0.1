/**
 * 
 */
package com.vinayparihar.spring.mvc.restapi.dao;

import java.util.List;

import com.vinayparihar.spring.mvc.restapi.model.UserDetails;

/**
 * @author VinayParihar
 * @alphaX @date Jun 1, 2020 @time 11:40:39 PM
 */

public interface IUserLogInDAO {

	public UserDetails getUserbyEmail(String email);

	// public boolean authenticateUser(String email, String password);
	
	public List<UserDetails> getAllUsers(int offset, int limit);

}
