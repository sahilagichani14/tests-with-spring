package testswithspring;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) //instruct Junit4 that we are running spring application, usually for testing service+data layer as integration test
// @RunWith(MockitoJUnitRunner.class) // instruct Junit4 env that we will use Mock objects
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE) //tell Junit that its SpringBoot app so Junit env bootstrap all required spring components, we specify webEnvironment to remove all controllers from context
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // tell Junit to provide all servlet engine behaviour, & load controllers, service. repository
@DataJpaTest // help to test JPA code
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // to use same DB that we have in .env
class TestsWithSpringApplicationTests {

	@Rule
	public MockitoRule rule = MockitoJUnit.rule(); //if we use this, it will initialise all @Mock, we don't need MockitoJUnitRunner.class or MockitoAnnotations.initMocks(this)

	@Mock
	private UserRepo userRepoMock;
	@InjectMocks
	private UserManagementService userManagementService;

	@Autowired
	private UserController userController; //@Controller is MVC controller i.e returns View Model unlike @RestController JSON/XML

	// Unit test MVC controller & put @WebMvcTest(UserController.class) at top of class
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private UserManagementService userManagementServiceMock;
	@InjectMocks
	private UserController userControllerMock;

	// test integration test of Repository
	@Autowired
	private TestEntityManager testEntityManager;
	@Autowired
	private UserRepo userRepo;


	@Before
	@Deprecated
	public void setUp(){
		//MockitoAnnotations.initMocks(this);
	}

	@Test
	void contextLoads() throws Exception {
		User mockUser = new User();
		when(userRepo.save(any(User.class))).thenReturn(mockUser);

		assertThat("result", is(equalTo("success")));

		mockMvc.perform(post("/testcontroller", new User()))
				.andExpect(status().isOk()).andReturn();

		mockMvc.perform(post("/testcontroller", new User()))
				.andExpect(status().is(302))                      // when user doesn't have any field so we give 302 status code
				.andReturn();

		testEntityManager.persist(new User());

	}

}
