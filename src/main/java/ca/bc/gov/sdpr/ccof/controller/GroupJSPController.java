package ca.bc.gov.sdpr.ccof.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ca.bc.gov.sdpr.ccof.model.security.User;
import ca.bc.gov.sdpr.ccof.service.security.GroupService;
import ca.bc.gov.sdpr.ccof.ui.model.security.GroupUI;
import ca.bc.gov.sdpr.ccof.ui.model.security.RoleUI;
import ca.bc.gov.sdpr.ccof.ui.model.security.UserUI;

@RestController
@RequestMapping("/jsp/group")
public class GroupJSPController {
	@Autowired
	GroupService groupService;
	
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public ResponseEntity<String> alive(HttpServletRequest request){
		return ResponseEntity.ok().body("Alive");
	}
	
	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public ModelAndView displayGroups(ModelAndView model) throws IOException{
		List<GroupUI> groups = groupService.getAllGroupsUI();
		model.addObject("listGroup", groups);
		model.setViewName("Groups");
		return model;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createNewGroup(ModelAndView model){
		GroupUI group = new GroupUI();
		model.addObject("group", group);
		model.setViewName("GroupCreate");
		return model;
	}
	
	@RequestMapping(value="/saveNewGroup", method = RequestMethod.POST)
	public ModelAndView saveNewGroup(@ModelAttribute GroupUI groupUI) {
		//Ensure ID for new group is null
		groupUI.setId(null);
		groupService.saveGroup(groupUI);
		return new ModelAndView("redirect:/jsp/group/display");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteGroup(HttpServletRequest request){
		String id = request.getParameter("id");
		groupService.deleteGroup(id);
		return new ModelAndView("redirect:/jsp/group/display");
	}
	
	@RequestMapping(value = "/modifyGroupRole", method = RequestMethod.GET)
	public ModelAndView modifyUserGroup(HttpServletRequest request){
		ModelAndView model = new ModelAndView();
		String id = request.getParameter("id");
		GroupUI groupUI = groupService.getGroupUIById(id);
		List<RoleUI> groupRoles = groupService.getRoleUIsForGroup(id);
		List<RoleUI> addableRoles = groupService.getAddableRolesForGroup(id);
		
		model.addObject("group", groupUI);
		model.addObject("existingRoles", groupRoles);
		model.addObject("addableRoles", addableRoles);
		model.setViewName("GroupModify");
		return model;
	}
	
	@RequestMapping(value = "/removeRoleFromGroup/{groupId}/{roleId}", method = RequestMethod.GET)
	public ModelAndView removeRoleFromGroup(@PathVariable(required=true) String groupId, @PathVariable(required=true) String roleId){
		groupService.removeRoleFromGroup(groupId, roleId);
		return new ModelAndView("redirect:/jsp/group/modifyGroupRole?id="+groupId);
	}
	
	@RequestMapping(value = "/addRoleToGroup/{groupId}/{roleId}", method = RequestMethod.GET)
	public ModelAndView addRoleToGroup(@PathVariable(required=true) String groupId, @PathVariable(required=true) String roleId){
		groupService.addRoleToGroup(groupId, roleId);
		return new ModelAndView("redirect:/jsp/group/modifyGroupRole?id="+groupId);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute GroupUI groupUI){
		groupService.updateGroup(groupUI);
		return new ModelAndView("redirect:/jsp/group/display");
	}
	
}
