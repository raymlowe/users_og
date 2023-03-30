package ca.bc.gov.sdpr.ccof.service.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ca.bc.gov.sdpr.ccof.dao.security.UserDAO;
import ca.bc.gov.sdpr.ccof.model.security.User;
import ca.bc.gov.sdpr.ccof.service.impl.security.UserServiceImpl;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	UserDAO userDAO;
	
	@InjectMocks
	UserServiceImpl userService;
	
	@DisplayName("UserService save")
	@Test
	public void testSaveUser() {
		User user = new User();
		user.setFirstname("firstName");
		
		when(userDAO.saveUser(user)).thenReturn(user);
		User savedUser = userService.saveUser(user);
		
		assertEquals(savedUser.getFirstname(), user.getFirstname());
	}
	
}
