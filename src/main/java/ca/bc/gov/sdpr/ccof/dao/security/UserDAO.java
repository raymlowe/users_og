package ca.bc.gov.sdpr.ccof.dao.security;

import java.util.List;

import ca.bc.gov.sdpr.ccof.model.security.User;
import ca.bc.gov.sdpr.ccof.ui.model.security.UserUI;

public interface UserDAO {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public User get(String id);
	
	/**
	 * The user ID can be their IDIR Login
	 * @param userId
	 * @return
	 */
	public User getUser(String userId);
	
	/**
	 * 
	 * @return
	 */
	public List<User> getAllUsers();
	
	/**
	 * Get all users by groupID
	 * 
	 * @param groupId
	 * @return
	 */
	public List<User> getGroupUsers (String groupId);
	
	 /**
	  * 
	  * @param user
	  */
	public User saveUser (User user);
	
	/**
	 * 
	 * @param id
	 */
	public boolean delete(String id);
	
	/**
	 * 
	 * @param userUI
	 * @return
	 */
	public boolean updateUser(UserUI userUI);

}
