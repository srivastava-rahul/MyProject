/**
 * 
 */
package com.click.service;

import com.click.entity.User;

/**
 * @author parveen
 */
public interface UserService {
	/**
	 * @param userId
	 * @return
	 */
	public User findUserById(String userId);

	/**
	 * @param user
	 * @return
	 */
	User saveUser(User user);

	/**
	 * @param id
	 */
	public void activateUser(String id);
}
