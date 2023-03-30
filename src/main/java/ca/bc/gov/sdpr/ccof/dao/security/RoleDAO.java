package ca.bc.gov.sdpr.ccof.dao.security;

import java.util.List;

import ca.bc.gov.sdpr.ccof.model.security.Role;
import ca.bc.gov.sdpr.ccof.ui.model.security.RoleUI;

public interface RoleDAO {

	/**
	 * 
	 * @param roleId
	 * @return
	 */
	public Role get(String id);
	
	/**
	 * 
	 * @param roleName
	 * @return
	 */
	public Role getByName(String roleName);
	
	/**
	 * 
	 * @return
	 */
	public List<Role> getAllRoles();
	
	/**
	 * 
	 * @param role
	 */
	public void save (Role role);
	
	/**
	 * 
	 * @param role
	 */
	public boolean delete(final String id);
	
	/**
	 * 
	 * @param roleUI
	 * @return
	 */
	public boolean updateRole(RoleUI roleUI);
}
