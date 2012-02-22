package fishpickle

import static org.junit.Assert.*
import grails.converters.JSON
import groovyx.net.http.ContentType
import groovyx.net.http.HTTPBuilder

import org.junit.*

class UserRestIntegrationTests {

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
    void testSingleUser() {
        def client = new HTTPBuilder("http://localhost:8080/fishpickle/rest/user/1")
		def resp = client.get(contentType : ContentType.JSON,  headers : [Accept : 'text/json'] )

		assertNotNull resp
		assertEquals(1, resp.id)
		assertEquals('user1', resp.login)
    }
	
	@Test
	void testAllUsers() {
		def client = new HTTPBuilder("http://localhost:8080/fishpickle/rest/user")
		def resp = client.get(contentType : ContentType.JSON,  headers : [Accept : 'text/json'] )

		assertNotNull resp
		assertEquals([1,2], resp.id)
		assertEquals(['user1', 'user2'], resp.login)
	}
	
	@Test
	void testSingleUsersGroups() {
		def client = new HTTPBuilder("http://localhost:8080/fishpickle/rest/user/2/groups")
		def resp = client.get(contentType : ContentType.JSON,  headers : [Accept : 'text/json'] )

		assertNotNull resp
		assertEquals(['All Users', 'Admin'], resp.name)
	}
	
	@Test
	void testSaveNewUser() {
		def client = new HTTPBuilder("http://localhost:8080/fishpickle/rest/user")
		def jsonUser = createUser("user3", "New User", "zzz") as JSON
		def resp = client.post(body : [user: jsonUser], contentType : ContentType.JSON,  headers : [Accept : 'json'] )
		
		def respUser = new User(resp)
		assertNotNull respUser
	}
	
	@Test
	void testSaveNewGroupToUser() {
		def client = new HTTPBuilder("http://localhost:8080/fishpickle/rest/user/1/groups")
		def jsonGroup = new UserGroup(name:"New Group 1") as JSON
		def resp = client.post(body : [group: jsonGroup], contentType : ContentType.JSON,  headers : [Accept : 'json'] )
		
		assertNotNull resp
	}
	
	User createUser(String login, String name, String password) {
		def user = new User(
			id: 0,
			login:login,
			displayName: name,
			password: password
			)
		
	}
}
