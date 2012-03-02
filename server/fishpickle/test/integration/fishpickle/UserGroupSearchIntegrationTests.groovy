package fishpickle

import static org.junit.Assert.*
import grails.converters.JSON
import groovyx.net.http.ContentType
import groovyx.net.http.HTTPBuilder

import org.junit.*

class UserGroupSearchIntegrationTests {

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
    void testGroupSearch() {
         def client = new HTTPBuilder("http://localhost:8080/fishpickle/rest/search/group/A")
		def resp = client.get(contentType : ContentType.JSON,  headers : [Accept : 'text/json'] )

		assertNotNull resp
    }
}
