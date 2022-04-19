package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseurl="https://opensource-demo.orangehrmlive.com/";
    // set up browser
    @Before
    public void setup(){
        openbrowser(baseurl);
    }
    @Test
    public void loginSuccessfullyWithValidCredentials(){
        // enter username
        WebElement username=driver.findElement(By.name("txtUsername"));
        username.sendKeys("Admin");
        // enter password
        WebElement password=driver.findElement(By.id("txtPassword"));
        password.sendKeys("admin123");
        // login button
        WebElement loginbtn=driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginbtn.click();
        // varify assert welcometext
        String expectedmessage= "Welcome";
        WebElement actualmessage=driver.findElement(By.xpath("//a[@id='welcome']"));
        String actualmessage1=actualmessage.getText();
        String actualmessage2=actualmessage1.substring(0,7);
        //now assert
        Assert.assertEquals("welcome page open",expectedmessage,actualmessage2);
    }
     @Test
    public void navigateToForgotPasswordPageSuccessfully(){
        // click on forgot password
         WebElement forgetpw=driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]"));
         forgetpw.click();
         WebElement forgotpassword=driver.findElement(By.xpath("//h1[contains(text(),'Forgot Your Password?')]"));// actual redirecting
        String expected="Forgot Your Password?";
        String actualmessage=forgotpassword.getText();// save in string actual forget password
        // now asscerting actual and expected
        Assert.assertEquals("Forgot your password",expected,actualmessage);

     }
     @After
    public void testdown(){
        closeBrowser();
     }





}
