package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlogPage extends BaseClass {
    WebDriver driver;

    Faker faker = new Faker();

    public BlogPage() {
        this.driver = BaseClass.driver;
        PageFactory.initElements(this.driver, this);
    }

    public void checkBlogPage() {
        assertEquals(driver.getTitle(), get("blog_page_title"));
        assertEquals(driver.getCurrentUrl(), get("blogpage_url"));
    }

    @FindBy(xpath = "//*[text()= 'Load more']")
    private WebElement loadMoreButton;

    @FindBy(xpath = "//body/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/article[67]/div[1]/a[1]")
    private WebElement articleName;

    private void buttonNotVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(loadMoreButton));
    }

    @FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]")
    private WebElement pageCount;

    @FindBy(xpath = ".//input[@name='Email']")
    private WebElement emailField;

    @FindBy(id = "form-newsletter-blog-submit-btn")
    private WebElement submitButton;

    @FindBy(className = "mc4wp-response")
    private WebElement thankYouMessage;


    public void fillInEmail() {
        js.executeScript("arguments[0].scrollIntoView(false);", emailField);
        emailField.sendKeys(faker.internet().emailAddress());
    }

    public void clickSubmitButton() {
        submitButton.click();
        thankYouMessage.isDisplayed();

    }


    public void scrollToArticle() throws InterruptedException {


        boolean test3 = true;

        do {
            js.executeScript("arguments[0].scrollIntoView(false);", loadMoreButton);
            Thread.sleep(1000);
            js.executeScript("arguments[0].click()", loadMoreButton);

            String test = pageCount.getText();
            String test1 = "Showing 1-68 (68) results";
            boolean test2 = test.equals(test1);
            if(test2 && test3){
                break;
            }
        } while (test3);

    }

    public void navigateToArticle() {

        js.executeScript("arguments[0].scrollIntoView(false);", articleName);
        js.executeScript("arguments[0].click()", articleName);
        assertEquals(driver.getTitle(), get("article_url"));
        assertEquals(driver.getCurrentUrl(), get("article_title"));

    }
}






