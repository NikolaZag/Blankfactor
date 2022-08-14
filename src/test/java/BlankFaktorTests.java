import Pages.BlankFactorHomePage;
import Pages.BlogPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class BlankFaktorTests extends BlankFactorHomePage {

    BlankFactorHomePage blankFactorHomePage;
    BlogPage blogPage;





    @BeforeEach
public void startBrowser() {
    setup();


}
// Navigate to Article Test
    @Test
    public void navigateToArticlePage() throws InterruptedException {
        blankFactorHomePage = new BlankFactorHomePage();
        blogPage = new BlogPage();
        blankFactorHomePage.openHomePage();
        blankFactorHomePage.acceptCookies();
        blankFactorHomePage.mouseOver();
        blankFactorHomePage.clickBlogButton();
        blogPage.checkBlogPage();
        blogPage.scrollToArticle();
        blogPage.navigateToArticle();



    }
// subscribe to newsletter test
    @Test
    public void subscribeToNewsletter(){
        blankFactorHomePage = new BlankFactorHomePage();
        blogPage = new BlogPage();
        blankFactorHomePage.openHomePage();
        blankFactorHomePage.acceptCookies();
        blankFactorHomePage.mouseOver();
        blankFactorHomePage.clickBlogButton();
        blogPage.checkBlogPage();
        blogPage.fillInEmail();
        blogPage.clickSubmitButton();

    }

    @AfterEach
    public void closeBrowser(){
    tearDown();
    }
}
