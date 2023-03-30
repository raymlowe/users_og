package ca.bc.gov.sdpr.ccof.utils;

import ca.bc.gov.sdpr.ccof.model.security.User;
import ca.bc.gov.sdpr.ccof.ui.model.security.UserUI;

public class UserUIObjectTransform {
	public static User convertToUser(UserUI userUI) {
		User user = new User();
		user.setId(userUI.getId());
		user.setUserId(userUI.getUserId().toUpperCase());
		user.setFirstname(userUI.getFirstName());
		user.setLastname(userUI.getLastName());
		user.setEmail(userUI.getEmail());
		user.setPhone(userUI.getPhone());
		user.setUsertype(userUI.getUserType());
		user.setIsactive(userUI.getIsActive());
		
		return user;
	}
	
	public static UserUI converToUserUI(User user) {
		UserUI userUI = new UserUI();
		userUI.setEmail(user.getEmail());
		userUI.setFirstName(user.getFirstname());
		userUI.setId(user.getId());
		userUI.setIsActive(user.getIsactive());
		userUI.setLastName(user.getLastname());
		userUI.setPhone(user.getPhone());
		userUI.setUserId(user.getUserId().toUpperCase());
		userUI.setUserType(user.getUsertype());
		
		return userUI;
	}
}
