package ca.bc.gov.sdpr.ccof.service.security;

import java.util.List;

import ca.bc.gov.sdpr.ccof.model.security.Group;
import ca.bc.gov.sdpr.ccof.ui.model.security.GroupUI;
import ca.bc.gov.sdpr.ccof.ui.model.security.RoleUI;

public interface GroupService {

	/**
	 * 
	 * @param group
	 * @return
	 */
	public Group saveGroup(Group group);
	
	/**
	 * 
	 * @param groupUI
	 * @return
	 */
	public GroupUI saveGroup(GroupUI groupUI);
	
	/**
	 * 
	 * @return
	 */
	public List<Group> getAllGroups();
	
	/**
	 * 
	 * @return
	 */
	public List<GroupUI> getAllGroupsUI();
	
	/**
	 * 
	 * @param groupId
	 * @return
	 */
	public Group getGroupById(String id);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public GroupUI getGroupUIById(String id);
	
	/**
	 * 
	 * @param groupdId
	 * @param roleId
	 * @return
	 */
	public List<RoleUI> addRoleToGroup(String groupId, String roleId);
	
	/**
	 * 
	 * @param groupId
	 * @param roleId
	 * @return
	 */
	public List<RoleUI> removeRoleFromGroup(String groupId, String roleId);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteGroup(String id);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<RoleUI> getRoleUIsForGroup(final String id);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<RoleUI> getAddableRolesForGroup(final String id);
	
	/**
	 * 
	 * @param groupUI
	 * @return
	 */
	public GroupUI updateGroup(GroupUI groupUI);
}
