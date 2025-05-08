package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.ConfigReader;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        if (driver == null) {
            boolean isCI = System.getenv("CI") != null;

            WebDriverManager.firefoxdriver().clearDriverCache().setup();

            FirefoxOptions firefoxOptions = new FirefoxOptions();
            if (isCI) {
                firefoxOptions.addArguments("--headless");
                firefoxOptions.addArguments("--disable-gpu");
                firefoxOptions.addArguments("--window-size=1920x1080");
                firefoxOptions.addArguments("--no-sandbox");
            }

            driver = new FirefoxDriver(firefoxOptions);

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(ConfigReader.get("baseUrl"));
        }
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.out.println("Error during WebDriver quit: " + e.getMessage());
            }
        }
    }
}
