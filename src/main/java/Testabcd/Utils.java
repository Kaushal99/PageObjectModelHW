package Testabcd;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Utils extends BasePage
{
    //switching the element to select from scroll down.
//    public void selectElementFromScrollDown(By by,String text)
//    {
//        Select dropElement = new Select(driver.findElement(by));
//        if (dropElement.isMultiple())
//        {
//            dropElement.selectByVisibleText(text);
//            return;
//        }
//
//    }
    //get the URl to Open product
    public static void currentUrl(String text){driver.get(text);}

    //Clicking element
    public static void clickingElement(By by)
    {
        driver.findElement(by).click();
    }

    //Clear Text form inout box/area
    public static void clearTextFormInoutBox(By by,String text)
    {
        driver.findElement(by).clear();
    }



    //Enter text in input field
    public static void userShouldEnterTextInField(By by,String text)
    {

        driver.findElement(by).sendKeys(text);
    }



    //Clear and enter text in input field
    public static void clearAndEnterTextInField(By by,String text)
    {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }



    //Checking WebElement present in DOM
    public static void checkingWebElementPresent(By by)
    {
        if (driver.findElement(by).isDisplayed())
        {
            System.out.println("Element is Present");
        }else
        {
            System.out.println("Element is not present");
        }
    }



    //Checking WebElement displayed or not
    public static  boolean checkWebElementDisplayed(By by)
    {
        return driver.findElement(by).isDisplayed();
    }




    //Wait for fixed time given in seconds
    public static void useWaitForFixedTimeGivenInSecond(By by,int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }



    //Try to click element three times if not available in first go
    public static void clickElementThreeTimes(By by) {
        if (driver.findElement(by).isDisplayed()) {
            driver.findElement(by).click();

        } else if (driver.findElement(by).isDisplayed()) {
            driver.findElement(by).click();
        } else if (driver.findElement(by).isDisplayed()) {
            driver.findElement(by).click();
        } else {
            System.out.println("Element in not clickable");
        }
    }


    //is drop down present

    //for drop down if text is present (e.g month,text etc.)

    public static void dropDownPresent(By by,String text)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }





    //Wait for locator to be clickable for given time in seconds
    public static void clickableLocatorForSeconds(By by,int time)
    {

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }




    //Wait for element to be clickable for given time in seconds
    public static void clickableElementBySeconds(By by,int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(by));

    }



    ////date stamp short
    public static void shortDateStamp(int time)
    {
        DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHMMSS");
        Date date = new Date();
        String getCurrentDateTime = dateFormat.format(date);
        System.out.println(dateFormat.format(date));
    }


    //date stamp long
    public static void longDateStamp(int time)
    {
        Date date = new Date();
        System.out.println(new Timestamp(date.getTime()));

    }

    ////Wait for element for given time in second
    public static void waitForElementTime(By by,int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    //wait for element to be invisible
    public static void waitForElementInvisible(By by,int time)
    {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

    }

    // select from visible text
    public static void visibleText(By by,String text)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);

    }

    //Select from visible number
    public static void visibleNumber(By by,String text)
    {
        WebElement element = driver.findElement(by);
        Select select = new Select(element);
        select.selectByVisibleText("text");

    }

    //Select from value
    public static void selectFromValue(By by,String value)
    {

        WebElement element = driver.findElement(by);
        Select select = new Select(element);
        select.selectByValue(value);

    }

    // get selected value from dropdown
    public static void getSelectedValue(By by)
    {
        Select select = new Select(driver.findElement(by));
        WebElement element = select.getFirstSelectedOption();
        String defaultItem = element.getText();
        System.out.println(defaultItem );

    }

    //Scroll to view element
    public static void scrollViewElement(By by)
    {

        WebElement element = driver.findElement(by);
        JavascriptExecutor je = (JavascriptExecutor)driver;
        je.executeScript("arguments[0].scrollIntoView(true);",element);
        System.out.println(element.getText());

    }
    //Scroll to element and click
    public static void scrollElementClick(By by)
    {
        WebElement element = driver.findElement(by);
        Select select = new Select(element);
        JavascriptExecutor je = (JavascriptExecutor)driver;
        je.executeScript("arguments[0].scrollIntoView(true);",element);
        select.selectByVisibleText("August");
        System.out.println(element.getText());

    }
    //Wait for alert to display
    public static void alertToDisplay(By by,int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());

    }
    //Get attribute of element
    public static void getElementAttribute(By by,String text)
    {
        WebElement element = driver.findElement(by);
        element.getAttribute("text");

    }

    //get css property of element
    public static void getCssPropertyElement(By by)
    {
        WebElement element = driver.findElement(by);
        String allCssProperty = element.getCssValue("text");

    }
    //take screenshot of browser
    public static void browserScreenshot()
    {
        //This takes screenshot of the browser and store it tom specific location

        try {
            File shot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(shot, new File("C:\\Programme File\\SRC"));
        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    //take screenshot of current display(full)
    public static void currentDisplayScreenShot() {
        try {
            // Setting your Chrome options (Desired capabilities)
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--start-fullscreen");

            // Creating a driver instance with the previous capabilities
            WebDriver driver = new ChromeDriver(options);

            // Load page & take screenshot of full-screen page
            driver.get("http://demo.nopcommerce.com/login");
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("C:\\Programme File\\SRC"));
        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }


    //convert date....
    public static void converDate() throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy HH:mm:ss");
        Date date = new Date();
        String getCurrentDateTime = dateFormat.format(date);
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy HH:mm:ss", Locale.ENGLISH);
        Date date1 = format.parse(getCurrentDateTime);
        System.out.println(date1);
    }
    //method to call assert

    private static String getTextMessage(By by)
    {
        return null;
    }
    public static void assertTextMessage(String expected,By by)
    {
        String actual = getTextMessage(by);
        Assert.assertEquals(expected,actual);

    }



    //calling Assert by URL
    public static void asserURL(String text)
    {
        Assert.assertTrue(driver.getCurrentUrl().contains(text));
    }

}
