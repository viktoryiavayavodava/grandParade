import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainPage
{
    private WebDriver driver;

    public MainPage (WebDriver driver){
        this.driver=driver;
    }

    @FindBy (className = "btn-search-magnifier")
    private WebElement searchIcon;

    @FindBy (xpath = ".//div[@class='app']//input")
    private WebElement searchGameField;

    @FindBy (xpath = ".//div[@class='tiles-shift-group']/div[1]")
    private WebElement gameIcon;

    @FindBy (className = "tile-menu__button--more" )
    private WebElement moreGameButton;

    @FindBy (className = "tile-menu__button--play" )
    private WebElement playGameButton;

    @FindBy (xpath = "///div[contains(text(),'Play Now')]" )
    private WebElement playNowButton;


    @FindBy (xpath = "//div[@class='burger']" )
    private  WebElement menuButton;



    public MainPage searchForGame (String game) throws IOException {
        String fileName = "C:\\Users\\Lenovo\\IdeaProjects\\slotMachineTask\\src\\main\\resources\\gameNames.csv";
        this.game = FileReader.getTestDataGame(fileName);
        searchIcon.click();
        searchIcon.click();
        searchGameField.clear();
        searchGameField.click();
        searchGameField.sendKeys(game);
        return this;
    }

    public LoginScreen playGame (){
        Actions action = new Actions(driver);
        action.moveToElement(gameIcon).build().perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        moreGameButton.click();
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement element = wait.until(
//                ExpectedConditions.elementToBeClickable(playGameButton));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        playGameButton.submit();
        return new LoginScreen(driver);

    }
    private String game;

    public LoginScreen loginViaGame (String game) throws IOException {
        String fileName = "gameNames.txt";
        this.game = FileReader.getTestDataGame(fileName);
        searchForGame (game);
        playGame();
        return new LoginScreen(driver);

    }

    public LoginScreen clickPlay(){
        playGameButton.click();
        return new LoginScreen(driver);
    }

    public void clickMenuButton(){
        menuButton.click();
    }











}

