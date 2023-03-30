package ca.bc.gov.sdpr.ccof.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ca.bc.gov.sdpr.ccof.service.security.RoleService;
import ca.bc.gov.sdpr.ccof.ui.model.security.RoleUI;
import ca.bc.gov.sdpr.ccof.ui.model.security.UserUI;

@RestController
@RequestMapping("/jsp/role")
public class RoleJSPController {
	@Autowired
	RoleService roleService;
	
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public ResponseEntity<String> alive(HttpServletRequest request){
		return ResponseEntity.ok().body("Alive");
	}
	
	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public ModelAndView displayRoless(ModelAndView model) throws IOException{
		List<RoleUI> roles = roleService.getAllRolesUI();
		model.addObject("listRole", roles);
		model.setViewName("Role");
		return model;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createNewRole(ModelAndView model){
		RoleUI role = new RoleUI();
		model.addObject("role", role);
		model.setViewName("RoleCreate");
		return model;
	}
	
	@RequestMapping(value = "/saveNewRole", method = RequestMethod.POST)
	public ModelAndView saveNewRole(@ModelAttribute RoleUI roleUI){
		//We need to ensure the roleUI.id is null for create
		roleUI.setId(null);
		roleService.saveRole(roleUI);
		return new ModelAndView("redirect:/jsp/role/display");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteRole(HttpServletRequest request){
		String id = request.getParameter("id");
		roleService.deleteRole(id);
		return new ModelAndView("redirect:/jsp/role/display");
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute RoleUI roleUI){
		roleService.updateRole(roleUI);
		return new ModelAndView("redirect:/jsp/role/display");
	}
}
