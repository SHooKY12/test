import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PageOfGame extends TestSuite {
    WebDriver driver = TestSuite.driver;
    private final WebElement startGameButton = driver.findElement(By.xpath("//a[@id='host_start']"));
    List<String> texts = new ArrayList<>();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    private WebElement elementForFocus;
    private WebElement fieldForEdit;

    public PageOfGame ClickStartGameButton() {
        if (startGameButton.isDisplayed()) {
            startGameButton.click();
        }
        return this;
    }

    public PageOfGame WaitStartGame() {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='typefocus']")));
        elementForFocus = driver.findElement(By.xpath("//span[@id='typefocus']"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='fixtypo']/following-sibling::input")));
        fieldForEdit = driver.findElement(By.xpath("//div[@id='fixtypo']/following-sibling::input"));
        wait.until(ExpectedConditions.elementToBeClickable(fieldForEdit));
        return this;
    }

    public void PlayGame() throws InterruptedException {
        WebElement aftterFfocusTextsr = driver.findElement(By.xpath("//span[@id='afterfocus']"));
        WebElement elementForFocus2 = driver.findElement(By.xpath("//span[@id='typefocus']"));
        String text = elementForFocus2.getAttribute("innerText");
        String textForAddInList = aftterFfocusTextsr.getAttribute("outerText");
        texts.add(text);
        texts.addAll(Arrays.asList(textForAddInList.split(" ")));
        int counter = texts.size();
        for (String inputText : texts) {
            counter--;
            String changedText = changeWords(inputText);
            if (!inputText.equals("")) {
                fieldForEdit.sendKeys(changedText);
                if (counter != 0) {
                    fieldForEdit.sendKeys(Keys.SPACE);
                }
                Thread.sleep(900);
            }
        }
    }

    private String changeWords(String text) {
        return text.replace("c", "с").replace("o", "о");
    }
}
