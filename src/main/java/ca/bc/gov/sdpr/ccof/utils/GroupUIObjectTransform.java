package ca.bc.gov.sdpr.ccof.utils;

import ca.bc.gov.sdpr.ccof.model.security.Group;
import ca.bc.gov.sdpr.ccof.ui.model.security.GroupUI;

public class GroupUIObjectTransform {
	public static GroupUI convertToGroupUI(Group group) {
		GroupUI groupUI = new GroupUI();
		groupUI.setId(group.getId());
		groupUI.setGroupName(group.getGroupName().toUpperCase());
		groupUI.setGroupDescription(group.getGroupDescription());
		return groupUI;
	}
	
	public static Group convertUIToGroup(GroupUI groupUI) {
		Group group = new Group();
		group.setId(groupUI.getId());
		group.setGroupName(groupUI.getGroupName().toUpperCase());
		group.setGroupDescription(groupUI.getGroupDescription());
		return group;
	}
}
