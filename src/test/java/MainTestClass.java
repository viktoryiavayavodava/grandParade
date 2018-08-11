import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class MainTestClass  {

    private WebDriver driver;
    private MainPage mainPage;
    private LoginScreen loginScreen;
    private String game;
    private String username;
    private  String password;


    @Before
    public void setUp() throws IOException {
        System.setProperty ("webdriver.chrome.driver","C:\\Users\\Lenovo\\IdeaProjects\\slotMachineTask\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver( options );
        driver.get("https://vegas.williamhill.com");
        mainPage = new MainPage(driver);
        loginScreen = new LoginScreen(driver);
        LoginScreen loginScreen = mainPage.loginViaGame (game);
    }


    @Test
    public void credentialsIncorrectTest() throws IOException {
        loginScreen.loginIncorrect(username,password);
        String errorHeader = loginScreen.getErrorHeader();
        String errorText=loginScreen.getErrorText();
        Assert.assertEquals("Sorry, the username / password that you've entered is incorrect.",errorHeader);
        Assert.assertEquals("Please try again or click here to recover your account.", errorText);
    }

    @Test
    public void credentialsInvalidTest() throws IOException {
        loginScreen.loginInvalid (username,password);
        String errorUsername = loginScreen.getUsernameErrorText();
        String errorPassword=loginScreen.getPasswordErrorText();
        Assert.assertEquals("Username must contain only letters, numbers and underscores",errorUsername);
        Assert.assertEquals("Password must contain only letters, numbers, underscores and hyphens", errorPassword);
    }

    @Test
    public void credentialsValidTest() throws IOException {
        loginScreen.loginValid(username, password);
//        Assert.assertTrue(and some unique element of slot game here // or username locator in the top right corner);
    }

    @Test
    public void showHidePasswordTest(){
            //compare password entered and password shown

    }

    @Test
    public void closeLoginScreenTest(){
        //make sure screen is closed - assert some main page element presence (which is not present on Login screen)
}

    @Test
    public void forgotDetailsTest(){
        //assert some element on newly opened screen
    }

    @Test
    public void saveCredentialsTest(){
//        verify checkbox isSelected and !=isSelected
    }

    @Test
    public void joinUsTest(){
        //assert some element on newly opened screen
    }


    @After
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
        driver=null;

    }

}
