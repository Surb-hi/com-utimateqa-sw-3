package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    //Use @before junit method for open a browser for method
    public void setup() {
        openbrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //signin elements
        clickOnElement(By.linkText("Sign In"));

        //actual result
        String actualmsg = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));

        //expectedresult
        String expectedmsg = "Welcome Back!";

        //match actual and expected result
        Assert.assertEquals("", actualmsg, expectedmsg);
    }

    @Test
    public void verifyTheErrorMessage() {
        //signin elements
        clickOnElement(By.linkText("Sign In"));

        //emailfield element
        sendTextToElement(By.name("user[email]"), "mac123@gmail.com");

        //Password elements
        sendTextToElement(By.id("user[password]"), "mac123");

        //signin element
        clickOnElement(By.xpath("//div/input[@value='Sign in']"));

        //actual result
        String actualmsg = getTextFromElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));

        //expectedresult
        String expectedmsg = "Invalid email or password.";

        //match actual and expected result
        Assert.assertEquals("", actualmsg, expectedmsg);

    }

    @After
    //Here After method for close the browser
    public void teardown() {
        //closebrowser();
    }

}


