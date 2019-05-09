package Testabcd;

import org.junit.Test;

public class TestSuite extends BaseTest
{
    HomePage homepage = new HomePage();

    @Test
    public void userShouldNavigateToHomePage()
        {
        homepage.verifyUserOnHOmePage();
        }
        @Test
        public void userShouldSeeUsDollar()
        {
        homepage.verifyUserShouldSeeUSDollar();
        }
        @Test
    public void userShouldSelectTheCurrency()
        {
            homepage.selectCurrentFromScrollDown();
        }

}
