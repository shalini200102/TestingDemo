package stepDef;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginStepdef {

    WebDriver driver;

    @Given("user opens browser and myntra website")
    public void open_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.myntra.com");
    }

    @When("user clicks on women section")
    public void clickWomenSection() {
        driver.findElement(By.xpath("//a[text()='Women']")).click();
    }

    @When("user searches for {string}")
    public void user_searches_for(String item) {
        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search for products']"));
        searchBox.sendKeys(item);
        searchBox.sendKeys(Keys.ENTER);
    }

    @Then("product list should be displayed")
    public void verifyProduct() {
        boolean visible = driver.findElement(By.cssSelector("ul.results-base")).isDisplayed();
        assert visible;
        driver.quit();
    }
}
