package ca.bc.gov.sdpr.ccof.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ca.bc.gov.sdpr.ccof.model.security.User;
import ca.bc.gov.sdpr.ccof.service.security.UserService;
import ca.bc.gov.sdpr.ccof.ui.model.security.GroupUI;
import ca.bc.gov.sdpr.ccof.ui.model.security.UserUI;

@RestController
@RequestMapping("/jsp/user")
public class UserJSPController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public ResponseEntity<String> alive(HttpServletRequest request){
		return ResponseEntity.ok().body("Alive");
	}
	
	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public ModelAndView displayUsers(ModelAndView model) throws IOException{
		List<UserUI> users = userService.getAllUsers();
		model.addObject("listUser", users);
		model.setViewName("Users");
		return model;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createNewUser(ModelAndView model){
		UserUI user = new UserUI();
		model.addObject("user", user);
		model.setViewName("UserCreate");
		return model;
	}
	
	@RequestMapping(value = "/saveNewUser", method = RequestMethod.POST)
	public ModelAndView saveNewUser(@ModelAttribute UserUI userUI){
		//We need to ensure the userID.id is null for create
		userUI.setId(null);
		userService.saveUser(userUI);
		return new ModelAndView("redirect:/jsp/user/display");
	}
	
	@RequestMapping(value="/updateUser", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute UserUI userUI){
		userService.updateUser(userUI);
		return new ModelAndView("redirect:/jsp/user/display");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request){
		String id = request.getParameter("id");
		userService.deleteUser(id);
		return new ModelAndView("redirect:/jsp/user/display");
	}
	
	@RequestMapping(value = "/modifyUserGroup", method = RequestMethod.GET)
	public ModelAndView modifyUserGroup(HttpServletRequest request){
		ModelAndView model = new ModelAndView();
		String userId = request.getParameter("userId");
		UserUI user = userService.getUserUIByUserId(userId);
		List<GroupUI> userGroups = userService.getUserGroupUIs(userId);
		List<GroupUI> groupsUserIsNotIn = userService.getAddableGroups(userId);
		
		model.addObject("user", user);
		model.addObject("userGroups", userGroups);
		model.addObject("groupsAvailable", groupsUserIsNotIn);
		model.setViewName("UserModify");
		return model;
	}
	
	/**
	 * For this cotroller, userId / groupId are both GUIDS
	 * @param userId
	 * @param groupId
	 * @return
	 */
	@RequestMapping(value = "/removeUserFromGroup/{userId}/{groupId}", method = RequestMethod.GET)
	public ModelAndView removeUserFronGroup(@PathVariable(required=true) String userId, @PathVariable(required=true) String groupId){
		userService.removeGroupFromUser(userId, groupId);
		User user = userService.get(userId);
		String userIDValue = user.getUserId();
		return new ModelAndView("redirect:/jsp/user/modifyUserGroup?userId="+userIDValue);
	}
	
	/**
	 * For this cotroller, userId / groupId are both GUIDS
	 * @param userId
	 * @param groupId
	 * @return
	 */
	@RequestMapping(value = "/addUserToGroup/{userId}/{groupId}", method = RequestMethod.GET)
	public ModelAndView addUserToGroup(@PathVariable(required=true) String userId, @PathVariable(required=true) String groupId){
		userService.addGroupToUser(userId, groupId);
		User user = userService.get(userId);
		String userIDValue = user.getUserId();
		return new ModelAndView("redirect:/jsp/user/modifyUserGroup?userId="+userIDValue);
	}
	
}
