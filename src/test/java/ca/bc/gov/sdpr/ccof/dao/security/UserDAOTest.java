package ca.bc.gov.sdpr.ccof.dao.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ca.bc.gov.sdpr.ccof.model.security.User;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class UserDAOTest {

	@Mock
	UserDAO userDAO;
	
	User testUser = new User();
	
	String u1Id = "";
	String u1UserId = "";
	String u1Email = "";
	
	@BeforeAll
	public void setUp() throws Exception{
		
	}
	
	@AfterAll
	public static void tearDown() throws Exception{
		
	}
	
	@DisplayName("Alive?")
	@Test
	public void test() {
		assertEquals(1,1);
	}
	
	@DisplayName("Create Test User")
	@Test
	public void createUser() {
		
		User user = new User();
		user.setFirstname("firstName");
		user.setId("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		user.setUserId("ADAM");
		
		when(userDAO.getUser("ADAM")).thenReturn(user);
		
		userDAO.saveUser(testUser);
		User retUser = userDAO.getUser("ADAM");
		assertEquals(retUser.getUserId(), user.getUserId());
	}

}
