import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import java.io.File;
import java.net.URI;

public class FirstTest {

    private AppiumDriver driver;
    String appPath = new File("apks/org.wikipedia.apk").getAbsolutePath();

    @Before
    public void setUp() throws Exception{
        Capabilities options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("appium:deviceName", "emulator-5554")
                .amend("appium:appPackage", "org.wikipedia")
                .amend("appium:appActivity", ".main.MainActivity")
                .amend("appium:automationName", "UiAutomator2")
                .amend ("appium:app",appPath);

        driver = new AndroidDriver(
                new URI("http://localhost:4723/").toURL(),
                options
        );
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void firstTest(){
        System.out.println("First test run");
    }
}
