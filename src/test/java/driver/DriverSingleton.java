package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

    private static WebDriver driver;
    private static final String RESOURSE_PATH = "src\\test\\resources\\";

    private DriverSingleton(){}

    public static WebDriver getDriver(){
        if(null == driver){
            switch(System.getProperty("browser")){
                case "firefox": {
                    System.setProperty("webdriver.gecko.driver", RESOURSE_PATH + "geckodriver.exe");
                    driver = new FirefoxDriver();
                }
                default: {
                    System.setProperty("webdriver.chrome.driver", RESOURSE_PATH + "chromedriver.exe");
                    driver = new ChromeDriver();
                }
            }
        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }

}
