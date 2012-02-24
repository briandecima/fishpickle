package fishpickle

import static org.junit.Assert.*
import groovyx.net.http.ContentType
import groovyx.net.http.HTTPBuilder

import org.junit.*

class UserGroupAssociationIntegrationTests {

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

   @Test
	void testSaveNewUser() {
		def client = new HTTPBuilder("http://localhost:8080/fishpickle/rest/userGroupAssociation")
		def resp = client.post(body : [userGroupAssociation: getJsonAssociation() ], contentType : ContentType.JSON,  headers : [Accept : 'json'] )
		
		def respUser = new UserGroupAssociation(resp)
		assertNotNull respUser
	}
	
	String getJsonAssociation() {
		"{userId:3, groupId:2}"
	}
}
