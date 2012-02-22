package fishpickle

import static org.junit.Assert.*
import grails.converters.JSON

import org.junit.*

class UserIntegrationTests {

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
    void testSomething() {
        User user1 = User.findByLogin("user2")
	   def jsonUser = user1 as JSON
	   
	   println("User1 == " + jsonUser.toString())
    }
}
