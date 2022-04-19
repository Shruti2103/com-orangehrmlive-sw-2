package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    String baseurl="https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setup(){
        openbrowser(baseurl);
    }
    @After
    public void testdown(){
        closeBrowser();
    }
    @Test
    public void navigateToForgotPasswordPageSuccessfully(){
        WebElement forgotpassword=driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]"));
        forgotpassword.click();
        String expectedresult="Forgot Your Password?";
        WebElement actualresult=driver.findElement(By.xpath("//h1[contains(text(),'Forgot Your Password?')]"));
        String actualresult1=actualresult.getText();
        //Accert actual and expected
        Assert.assertEquals("Forfot your passsword",expectedresult,actualresult1);



    }

}
