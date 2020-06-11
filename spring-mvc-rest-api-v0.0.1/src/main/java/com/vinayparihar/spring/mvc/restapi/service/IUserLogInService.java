/**
 * 
 */
package com.vinayparihar.spring.mvc.restapi.service;

import java.util.List;

import com.vinayparihar.spring.mvc.restapi.bean.LogIn;
import com.vinayparihar.spring.mvc.restapi.bean.User;

/**
 * @author VinayParihar
 * @alphaX @date Jun 1, 2020 @time 2:00:58 PM
 */

public interface IUserLogInService {

	public User getUserbyEmail(String email);

	public List<User> getAllUsers(int offset, int limit);

	public boolean authenticateUser(LogIn logIn);

}
