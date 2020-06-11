/**
 * 
 */
package com.vinayparihar.spring.mvc.restapi.dao;

import com.vinayparihar.spring.mvc.restapi.model.UserDetails;

/**
 * @author VinayParihar
 * @alphaX @date Jun 1, 2020 @time 7:28:03 PM
 */

public interface IUserRegistrationDAO {

	public boolean createUser(UserDetails userDetails);

	public boolean ifUserEmailExists(UserDetails userDetails);

}
