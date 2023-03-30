package ca.bc.gov.sdpr.ccof.dao.security;

import java.util.List;

import ca.bc.gov.sdpr.ccof.model.security.Group;
import ca.bc.gov.sdpr.ccof.ui.model.security.GroupUI;

public interface GroupDAO {
	
	/**
	 * 
	 * @param groupId
	 * @return
	 */
	public Group get(String id);
	
	/**
	 * 
	 * @param groupName
	 * @return
	 */
	public Group getByName(String groupName);
	
	/**
	 * 
	 * @return
	 */
	public List<Group> getAllGroups();
	
	/**
	 * 
	 * @param group
	 */
	public void save (Group group);
	
	/**
	 * 
	 * @param group
	 * @return
	 */
	public boolean delete(final String id);
	
	/**
	 * 
	 * @param groupUI
	 * @return
	 */
	public boolean updateGroup(final GroupUI groupUI);

}
