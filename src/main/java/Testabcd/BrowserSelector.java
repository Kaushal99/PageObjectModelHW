package Testabcd;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class BrowserSelector extends Utils
{
    LoadProp loadProp = new LoadProp();
    public void setUpBrowser()
    {
        String browser = loadProp.getProperty("browser");
        //String setUpBrowser=System.getProperty("setUpBrowser");
        if (browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver","src/test/Resources/BrowserFactory/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobar");
            options.addArguments("__disable-extensions");
            options.addArguments("__disable-setUpBrowser-side-navigation");
            options.addArguments("__incognito");
            options.addArguments("__disable-blink-features=BlockCredentialedSubresources");
            driver=new ChromeDriver(options);
            driver.manage().window().fullscreen();
        }
        else if(browser.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.firefox.driver","src/test/Resources/BrowserFactory/geckodriver.exe");
            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
            driver = new FirefoxDriver();
            driver.manage().window().fullscreen();
        }
        else if (browser.equalsIgnoreCase("ie"))
        {
            System.setProperty("webdriver.ie.driver","src/test/Resources/BrowserFactory/IEDriverServer.exe");
            InternetExplorerOptions options = new InternetExplorerOptions();
            options.setCapability(InternetExplorerDriver.IE_SWITCHES,"-private");
            options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,"true");
            driver = new InternetExplorerDriver(options);
            driver.manage().window().maximize();
        }
        else
            {
                System.out.println("Browser Not Valid"+ browser);
            }
    }

}
