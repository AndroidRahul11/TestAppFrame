package qa.mobile;

import com.beust.jcommander.Parameter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    protected AppiumDriver driver;
    protected Properties props;
    InputStream inputStream;
    public BaseTest() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @Parameter(names = {"platformName", "platformVersion", "deviceName"})

    @BeforeTest
    public void BC(String platformVersion, String platformName, String deviceName) throws IOException {
        try {
            props = new Properties();
            String propFileName = "config.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            props.load(inputStream);

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", platformName);
            desiredCapabilities.setCapability("platformVersion", platformVersion);
            desiredCapabilities.setCapability("deviceName", deviceName);
            desiredCapabilities.setCapability("automationName", props.getProperty("androidAutomationName"));
            desiredCapabilities.setCapability("appPackage", props.getProperty("androidAppPackageName"));
            desiredCapabilities.setCapability("appActivity", props.getProperty("androidAppActivity"));
            desiredCapabilities.setCapability("app", "Users/rahul.vyavahare/Downloads/Testapps/Android-MyDemoAppRN.1.3.0.build-244.apk");

            URL url = new URL(props.getProperty("appiumURL"));

            driver = new AppiumDriver(url, desiredCapabilities);
            String sessionId = driver.getSessionId().toString();
            System.out.println("app launched successfully");


        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("App launch failed" + e.getMessage());

        }
    }
        public void waitForVisibility(WebElement e){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(e));
        }
    public void click(WebElement e){
        waitForVisibility(e);
        e.click();
    }
    public void sendKeys(WebElement e, String txt){
        waitForVisibility(e);
        e.sendKeys(txt);
    }

    public String getAttribute(WebElement e, String attribute){
        waitForVisibility(e);
       return e.getAttribute(attribute);
    }

    @AfterTest
        public void afterTest() {
        driver.quit();
        }
    }