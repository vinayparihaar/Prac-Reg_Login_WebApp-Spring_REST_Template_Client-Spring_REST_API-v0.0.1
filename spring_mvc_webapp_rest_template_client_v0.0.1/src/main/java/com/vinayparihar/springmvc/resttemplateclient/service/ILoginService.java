/**
 * 
 */
package com.vinayparihar.springmvc.resttemplateclient.service;

import com.vinayparihar.springmvc.resttemplateclient.beans.LogIn;
import com.vinayparihar.springmvc.resttemplateclient.beans.User;

/**
 * @author VinayParihar
 * @alphaX @date Jun 7, 2020 @time 11:25:48 AM
 */

public interface ILoginService {

	public User loginUser(LogIn logIn);

}
