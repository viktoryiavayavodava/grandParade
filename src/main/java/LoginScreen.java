import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.Collection;

public class LoginScreen
{
    private WebDriver driver;
    private Collection<String[]> username;
    private Collection<String[]> password;

    public LoginScreen (WebDriver driver){
        this.driver=driver;
    }

    @FindBy (xpath =  "//button[@class='c-login-form__register-link']")
    private WebElement joinButton;

    @FindBy (xpath = ".//div/form[@id='signupForm']//a")
    private WebElement forgotButton;

    @FindBy (xpath = "//span[contains(text(),'Close')]/parent::button")
    private WebElement closeButton;

    @FindBy (xpath = ".//*[@id='login-form-password']")
    private WebElement passwordField;

    @FindBy (xpath =".//*[@id='login-form-username']")
    private WebElement usernameField;

    @FindBy (xpath = ".//*[@id='login-form-username']")
    private WebElement logInButton;

    @FindBy (xpath = "//input[@id='rememberUsername']")
    private WebElement rememberFlag;

    @FindBy (xpath = ".//*[@id='login-form-password']/span")
    private WebElement showHide;

    @FindBy (className = "c-login-form__message-title")
    private WebElement errorHeaderLogin;

    @FindBy (className = "c-login-form__message-text")
    private WebElement errorTextLogin;

    @FindBy (xpath = ".//span[contains(text()='click here')]")
    private WebElement forgotButtonError;

    @FindBy (xpath = ".//*[@id='login-form-password']/following-sibling::p")
    private WebElement usernameError;

    @FindBy (className = "c-login-form__input-group-error")
    private WebElement passwordError;


//    private By keepLoggedIn = By.xpath("");
//    private By resetEmailField = By.id("inputEmailUsername");
//    private By resetButton = By.xpath("//div[@class='sb-input-group']//button/span[contains(text(),'Send password reset link')]");
//    private By reopenLink = By.linkText("Reopen Closed Account");
// mobile only
//    public LoginScreen checkKeepLoggedIn(){
//        driver.findElement (keepLoggedIn).click();
//        return this;
//    }

    public JoinPage clickJoin(){
        joinButton.click();
        return new JoinPage(driver);
    }

    public ForgotDetailsPage clickForgot(){
        forgotButton.click();
        return new ForgotDetailsPage (driver);
    }
    public ForgotDetailsPage clickForgotFromError(){
        forgotButtonError.click();
        return new ForgotDetailsPage (driver);
    }

    public MainPage clickClose () {
        closeButton.click();
        return new MainPage(driver);
    }

    public LoginScreen clickLogin(){
        logInButton.click();
        return this;
    }

    public LoginScreen checkRememberFlag(){
        rememberFlag.click();
        return this;
    }

    public LoginScreen showPassword (){
        showHide.click();
        return this;
    }

    public LoginScreen typeUsername(String username){
        usernameField.sendKeys(username);
        return this;
    }

    public LoginScreen typePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public LoginScreen loginInvalid (String username, String password) throws IOException {
        String fileName = "loginDataInvalid.txt";
        this.username = FileReader.getTestData(fileName);
        this.password = FileReader.getTestData(fileName);
        this.typeUsername(username);
        this.typePassword(password);
        this.clickLogin();
        return this;
    }

    public LoginScreen loginIncorrect (String username, String password) throws IOException {
        String fileName = "loginDataIncorrect.txt";
        this.username = FileReader.getTestData(fileName);
        this.password = FileReader.getTestData(fileName);
        this.typeUsername(username);
        this.typePassword(password);
        this.clickLogin();
        return this;
    }

    public GamePage loginValid (String username, String password) throws IOException {
        String fileName = "loginDataValid.txt";
        this.username = FileReader.getTestData(fileName);
        this.password = FileReader.getTestData (fileName);
        this.typeUsername(username);
        this.typePassword(password);
        this.clickLogin();
        return new GamePage (driver);
    }

    public String getErrorHeader (){
        return (errorHeaderLogin.getText());
    }

    public String getErrorText (){
        return (errorTextLogin.getText());
    }

    public String getUsernameErrorText (){
        return (usernameError.getText());
    }

    public String getPasswordErrorText (){
        return (passwordError.getText());
    }

    public boolean getShowHide (){
        String initialText = showHide.getText();
        showHide.click();
        String newText = showHide.getText();
        return initialText==newText;
    }

    public String getShowText(){
        String hint = showHide.getText();
        if (hint == "Show") {
            showHide.click();
            return passwordField.getText();
        }else
        { return passwordField.getText();
        }
    }

}

