package ca.bc.gov.sdpr.ccof.service.security;

import java.util.List;

import ca.bc.gov.sdpr.ccof.model.security.User;
import ca.bc.gov.sdpr.ccof.ui.model.security.GroupUI;
import ca.bc.gov.sdpr.ccof.ui.model.security.UserUI;

public interface UserService {

	/**
	 * 
	 * @param user
	 * @return
	 */
	public User saveUser (User user);
	
	/**
	 * 
	 * @param userUI
	 * @return
	 */
	public UserUI saveUser (UserUI userUI);
	
	/**
	 * 
	 * @param userUI
	 * @return
	 */
	public UserUI updateUser (UserUI userUI);
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public User getUserByUserId(String userId);
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public UserUI getUserUIByUserId(String userId);
	
	/**
	 * 
	 * @return
	 */
	public List<GroupUI> getUserGroupUIs(String userId);
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public List<String> getUserGroupNames(String userId);
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public List<String> getAmalgamatedRoles(String userId);
	
	/**
	 * 
	 * @param userId
	 * @param groupId
	 * @return
	 */
	public List<GroupUI> addGroupToUser(String userId, String groupId);
	
	/**
	 * 
	 * @param userId
	 * @param gorupId
	 * @return
	 */
	public List<GroupUI> removeGroupFromUser(String userId, String gorupId);
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public boolean deleteUser(String id);
	
	/**
	 * 
	 * @return
	 */
	public List<UserUI> getAllUsers();
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public List<GroupUI> getAddableGroups(final String userId);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public User get(final String id);
}
