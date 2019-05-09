package Testabcd;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest extends Utils
{
    BrowserSelector browserSelector = new BrowserSelector();

    @Before
    public void openBrowser()
    {
        browserSelector.setUpBrowser();
        currentUrl("http://demo.nopcommerce.com");
    }

    @After
    public void closeBrowser()
    {
        //driver.quit();
    }


}
