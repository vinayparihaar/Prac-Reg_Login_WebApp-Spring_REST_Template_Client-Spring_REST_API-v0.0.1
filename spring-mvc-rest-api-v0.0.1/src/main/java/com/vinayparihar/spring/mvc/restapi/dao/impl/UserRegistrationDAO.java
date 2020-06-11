/**
 * 
 */
package com.vinayparihar.spring.mvc.restapi.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vinayparihar.spring.mvc.restapi.dao.IUserRegistrationDAO;
import com.vinayparihar.spring.mvc.restapi.error.InvalidInputException;
import com.vinayparihar.spring.mvc.restapi.model.UserDetails;
import com.vinayparihar.spring.mvc.restapi.utils.DBUtils;

/**
 * @author VinayParihar
 * @alphaX @date Jun 1, 2020 @time 9:35:55 PM
 */

@Repository
public class UserRegistrationDAO implements IUserRegistrationDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRegistrationDAO.class);
	private EntityManager entityManager;

	@Transactional
	@Override
	public boolean createUser(UserDetails userDetails) {

		LOGGER.debug("Processing CreateUser.");
		try {
			entityManager = DBUtils.getEntityManagerFactory().createEntityManager();
			entityManager.getTransaction().begin();

			entityManager.persist(userDetails);

			entityManager.getTransaction().commit();
			LOGGER.debug("User data saved to database from createUser.");

		} catch (Exception exception) {

			LOGGER.error("Exception occured in createUser. " + exception.getMessage());
			throw new InvalidInputException("Invalid Input" + exception.getMessage());

		} finally {

			if (entityManager != null) {
				entityManager.close();
				entityManager = null;
				LOGGER.debug("Entity manager connection closed in createUser. ");
			}
		}
		return true;
	}

	@Override
	public boolean ifUserEmailExists(UserDetails userDetails) {

		LOGGER.debug("Processing ifUserEmailExists.");
		boolean result = false;
		try {
			entityManager = DBUtils.getEntityManagerFactory().createEntityManager();

			Query query = entityManager
					.createQuery("from UserDetails where userEmail='" + userDetails.getUserEmail() + "'");
			UserDetails uD = (UserDetails) query.getSingleResult();

			if (uD != null) {
				LOGGER.debug("User record exist in database with email, " + uD.getUserEmail());
				result = true;
			}
		} catch (NoResultException noResultException) {

			LOGGER.debug("User record doesn't exist." + noResultException.getMessage());
			return result;
		} catch (Exception exception) {

			LOGGER.error("Exception occured in createUser. " + exception.getMessage());
			throw new InvalidInputException("Invalid Input provided." + exception.getMessage());
		} finally {

			if (entityManager != null) {

				entityManager.close();
				entityManager = null;
				LOGGER.debug("Entity manager connection closed in ifUserEmailExists. ");
			}
		}
		return result;
	}
}
