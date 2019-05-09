package Testabcd;

import org.openqa.selenium.By;

public class HomePage extends Utils {

 LoadProp loadProp = new LoadProp();
 private By _homePage = By.xpath("//div[@class='!header-logo']");
 private By _currencyDollar = By.xpath("//select[@id='customerCurrency']");
 private By _currencyEuro = By.xpath("//option[@selected='selected']");

 public void verifyUserOnHOmePage()
 {

  assertTextMessage("User is on Homepage", _homePage);
 }

 public void verifyUserShouldSeeUSDollar()
 {
  String browser = loadProp.getProperty("browser");
  clickingElement(_currencyDollar);

 }

 public void selectCurrency()
 {
  //clickingElement(_currencyEuro);
 }


}