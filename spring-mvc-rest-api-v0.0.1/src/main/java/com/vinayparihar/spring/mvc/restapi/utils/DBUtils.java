/**
 * 
 */
package com.vinayparihar.spring.mvc.restapi.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author VinayParihar
 * @alphaX @date Jun 1, 2020 @time 9:39:33 PM
 */

public class DBUtils {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DBUtils.class);
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = getEntityManagerFactory();

	public static EntityManagerFactory getEntityManagerFactory() {
		
		LOGGER.debug("Processing getEntityManagerFactory.");
		if (ENTITY_MANAGER_FACTORY == null) {
			return Persistence.createEntityManagerFactory("UsersDetailsDB");
		}
		return ENTITY_MANAGER_FACTORY;
	}
}
