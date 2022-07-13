package ct.ct360task;

import ct.ct360task.controller.MainResource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MainControllerTest {

    private static final Logger LOGGER = Logger.getLogger(MainControllerTest.class.getName());

    @BeforeAll
    static void beforeAll() {
        //LOGGER.info("Logger Name: "+LOGGER.getName());
        //TODO: change to the name of the class with get?
        LOGGER.info("Starting Test Class with logger: " + LOGGER.getName());
    }

    @AfterAll
    static void afterAll() {
        LOGGER.info("Finished executing test class");
    }

    /*
    This will be a simple UNIT TEST to assert if our basic /hello endpoint returns a heading/title of hello world
    This is a JUNIT5 approach of logging, source: https://www.baeldung.com/junit-get-name-of-currently-executing-test
    */
    @Test
    void helloWorldTitleTest(TestInfo testInfo){
        LOGGER.info("Starting Test: " + testInfo.getDisplayName());
        final String headingTitle = "<h1>Hello world</h1>";
        MainResource controller = new MainResource(); // Arrange
        String response = controller.helloWorldTitleEndpoint();
        assertEquals(headingTitle, response);
        LOGGER.info("Ending Test: " + testInfo.getDisplayName());
    }
}
