/**
 * 
 */
package com.vinayparihar.spring.mvc.restapi.service;

import com.vinayparihar.spring.mvc.restapi.bean.User;

/**
 * @author VinayParihar
 * @alphaX @date Jun 1, 2020 @time 1:59:45 PM
 */

public interface IUserRegistrationService {

	public boolean createUser(User user);

	public boolean ifUserEmailExists(User user);

}
