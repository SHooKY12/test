import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class TestSuite {

    protected static WebDriver driver = new ChromeDriver();

    @BeforeTest
    private void setUp() {
        File chromeFile = new File("src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chromeFile.getAbsolutePath());
        driver.manage().window().maximize();
        driver.get("https://klavogonki.ru/");
    }

    @Test
    private void startGame() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.openGamePage();
        WebElement elementToClose = driver.findElement(By.xpath("//input[@value ='Закрыть']"));
        elementToClose.click();
        Thread.sleep(500);
        PageOfGame pageOfGame = new PageOfGame();
        pageOfGame.ClickStartGameButton().WaitStartGame().PlayGame();
    }
}
