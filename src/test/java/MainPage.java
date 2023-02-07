import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends TestSuite {
    private final WebDriver driver = TestSuite.driver;
    private final WebElement quickGameButton = driver.findElement(By.xpath("//a[@class='title'][1]"));

    public void openGamePage() {
        quickGameButton.click();
    }
}

