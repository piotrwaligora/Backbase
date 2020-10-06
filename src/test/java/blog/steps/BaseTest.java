package blog.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BaseTest {
    @Before
    public void before() {
        System.out.println("Before");
    }

    @After
    public void after() {
        System.out.println("After");
    }
}
