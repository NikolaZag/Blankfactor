package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class BlogPage extends BaseClass {
    WebDriver driver;

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






    public void scrollToArticle() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;



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

    public void navigateToArticle(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", articleName);
        js.executeScript("arguments[0].click()", articleName);
        assertEquals(driver.getTitle(), get("article_page"));
        assertEquals(driver.getCurrentUrl(), get("blogpage_url"));

    }
}






