package fishpickle

import static org.junit.Assert.*
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
		assertEquals(['Admin', 'All Users'], resp.name)
	}
}
