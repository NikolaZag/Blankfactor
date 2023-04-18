package Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlankFactorHomePage extends BasePage {

    WebDriver driver;
    public BlankFactorHomePage() {
        this.driver = BasePage.driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "menu-item-4436")
    private WebElement insightsMenu;


    @FindBy(id = "hs-eu-confirmation-button")
    private WebElement cookieAcceptButton;

    @FindBy(css ="#menu-item-4436 > div > div > div > div > div.insights-pages > a:nth-child(1)" )
    private WebElement blogButton;



    public void acceptCookies(){
        cookieAcceptButton.click();

    }


    public void mouseOver(){
        Actions actions = new Actions(driver);
        actions.moveToElement(insightsMenu).build().perform();

    }


public void clickBlogButton(){
blogButton.isDisplayed();
       blogButton.click();
}


    public void openHomePage(){
        Assertions.assertEquals(driver.getTitle(), get("home_page_title"));
        Assertions.assertEquals(driver.getCurrentUrl(), get("homepage_url"));
    }




}
