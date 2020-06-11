/**
 * 
 */
package com.vinayparihar.spring.mvc.restapi.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vinayparihar.spring.mvc.restapi.dao.IUserLogInDAO;
import com.vinayparihar.spring.mvc.restapi.error.UserNotFoundException;
import com.vinayparihar.spring.mvc.restapi.model.UserDetails;
import com.vinayparihar.spring.mvc.restapi.utils.DBUtils;

/**
 * @author VinayParihar
 * @alphaX @date Jun 2, 2020 @time 12:48:55 PM
 */

@Repository
public class UserLogInDAO implements IUserLogInDAO {

	private final static Logger LOGGER = LoggerFactory.getLogger(UserLogInDAO.class);
	private EntityManager entityManager;
	private UserDetails userDetails;
	private List<UserDetails> listOfUsers;

	@Override
	public UserDetails getUserbyEmail(String email) {

		LOGGER.debug("Processing getUserbyEmail.");
		try {
			entityManager = DBUtils.getEntityManagerFactory().createEntityManager();
			/* entityManager.getTransaction().begin(); */

			Query query = entityManager.createQuery("SELECT ud FROM UserDetails ud WHERE ud.userEmail = :email");
			query.setParameter("email", email);

			userDetails = (UserDetails) query.getSingleResult();
			/* entityManager.getTransaction().commit(); */
			LOGGER.debug("User record found in database for, " + email);
			
		} catch (Exception exception) {

			LOGGER.error("Exception occured in getUserbyEmail. " + exception);
			throw new UserNotFoundException(
					"User Not Found. " + " User record doesn't exist in database for, " + email);
		} finally {

			if (entityManager != null) {
				entityManager.close();
				entityManager = null;
				LOGGER.debug("Entity manager connection closed in createUser. ");
			}
		}
		return userDetails;
	}

	
	
	@Override
	public List<UserDetails> getAllUsers(int offset, int limit) {
		
		LOGGER.debug("Processing getAllUsers. ");
		listOfUsers = new ArrayList<UserDetails>();
		try {
			entityManager = DBUtils.getEntityManagerFactory().createEntityManager();
			/* entityManager.getTransaction().begin(); */

			Query query = entityManager.createQuery("SELECT ud FROM UserDetails ud", UserDetails.class);

			if (offset >= 0) {
				query.setFirstResult(offset);
			}
			if (limit >= 0) {
				query.setMaxResults(limit);
			}
			
			listOfUsers = (List<UserDetails>) query.getResultList();
			/* entityManager.getTransaction().commit(); */
			LOGGER.debug("Retrived All Users from database. ");

		} catch (Exception exception) {
			
			LOGGER.error("Exception occured in getAllUsers. " + exception);
			throw new UserNotFoundException("No records found. " + exception);
		} finally {
			
			if (entityManager != null) {
				entityManager.close();
				entityManager = null;
				LOGGER.debug("Entity manager connection closed in getAllUsers. ");
			}
		}
		return listOfUsers;
	}
}
