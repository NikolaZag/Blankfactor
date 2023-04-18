package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

public class BasePage {

    protected static WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    private Properties properties = new Properties();

    // This method is used to load the properties file
    private void loadPropertiesFile() {
        try {
                FileInputStream Locator = new FileInputStream("src/main/resources/config.properties");
                properties = new Properties();
                properties.load(Locator);
            } catch (IOException e) {
                e.printStackTrace();
            }

    }





    public String get(String key) {
        loadPropertiesFile();
        return properties.getProperty(key);

    }




    protected void setup()  {

        System.setProperty(get("browser"), get("driver_path"));


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        driver.get(get("homepage_url"));




    }



    public void tearDown() {
        BasePage.driver.quit();
    }


}