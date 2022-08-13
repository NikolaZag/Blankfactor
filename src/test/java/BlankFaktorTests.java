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
    @Test
    public void checkBlankFaktorPage() throws InterruptedException {
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

    @AfterEach
    public void closeBrowser(){
    tearDown();
    }
}
