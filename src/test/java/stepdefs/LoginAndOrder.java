package stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.ShopPage;

public class LoginAndOrder {
    ShopPage shopPage;
    WebDriver driver;
    String expectedText = "Your order on My Store is complete.";
    String actualText;
    String amount, totalPrice;
    WebDriverWait wait;

    @Before
    public void launchBrowserDriver() {
        driver = new ChromeDriver();
        shopPage = new ShopPage(driver);
        wait = new WebDriverWait(driver, 5);
    }

    @Given("^user navigate to the app url$")
    public void userNavigateToTheAppUrl()   {
        driver.get("http://automationpractice.com");
    }

    @When("^user signs in$")
    public void userSignsIn() {
        shopPage.signIn();
    }

    @When("^user inputs email with value \"([^\"]*)\"$")
    public void userInputsEmailWithValue(String userEmail) {
        shopPage.inputEmail(userEmail);
    }

    @And("^user inputs password with value \"([^\"]*)\"$")
    public void userInputsPasswordWithValue(String userPassword) {
        shopPage.inputPassWrd(userPassword);
    }

    @And("^user submits credentials$")
    public void userSubmitsCredentials()   {
        shopPage.logIn();
    }

    @And("^user selects 'Women' menu$")
    public void userSelectsWomenMenu()   {
        shopPage.selectGroup();
    }

    @And("^user selects 'Dresses'$")
    public void userSelectsDresses()   {
        shopPage.selectDepartment();
    }

    @And("^user selects 'Casual Dresses'$")
    public void userSelectsCasualDresses()   {
        shopPage.selectDressCode();
    }

    @And("^user selects product$")
    public void userSelectsProduct()   {
        shopPage.selectProduct();
    }

    @And("^user adds product to you cart$")
    public void userAddsProductToYouCart()   {
        shopPage.addToCart();
    }

    @And("^user clicks on 'Proceed to checkout'$")
    public void userClicksOnProceedToCheckout()   {

        try {
            //wait.until(ExpectedConditions.elementToBeClickable(checkOut1));
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        shopPage.checkOut_1();
    }

    @And("^user verifies cart, clicks on 'Proceed to checkout'$")
    public void userVerifiesCartClicksOnProceedToCheckout()   {
        shopPage.checkOut_2();
    }

    @And("^user verifies delivery/billing address, clicks on 'Proceed to checkout'$")
    public void userVerifiesDeliveryBillingAddressClicksOnProceedToCheckout()   {
        shopPage.checkDeliveryBillAddress();
    }

    @And("^user agrees on terns, clicks on 'Proceed to checkout'$")
    public void userAgreesOnTernsClicksOnProceedToCheckout()   {
        shopPage.agreeOnTerms();
    }

    @And("^user verifies delivery carrier, clicks on 'Proceed to checkout'$")
    public void userVerifiesDeliveryCarrierClicksOnProceedToCheckout()   {
        shopPage.checkOut_3();
    }

    @And("^user selects 'Pay by Check'$")
    public void userSelectsPayByCheck()   {
        shopPage.selectPayCheck();
    }

    @And("^user gets the order amount$")
    public void userGetsTheOrderAmount()   {
        amount = shopPage.getOrderAmount();
    }

    @And("^user clicks to confirm order$")
    public void userClicksToConfirmOrder()   {
        shopPage.userConfirmOrder();
    }

    @And("^user checks on order completion$")
    public void userChecksOnOrderCompletion()   {
        actualText = shopPage.completeOrderMsg();
    }

    @And("^user returns to the order$")
    public void userReturnsToTheOrder()   {
        shopPage.backToOrder();
    }

    @And("^user verifies order and total price$")
    public void userVerifiesOrderAndTotalPrice()   {
        totalPrice = shopPage.getTotalPrice();
        Assert.assertEquals(totalPrice, amount);
        System.out.println("Total order price is correct!\n");
        Assert.assertEquals(actualText, expectedText);
        System.out.println("Exit from 'My Store' with a complete order! Test pass.\n");
    }

    @And("^user logout from account$")
    public void userLogoutFromAccount()   {
        shopPage.logOff();
    }

    @After
    public void stopBrowserDriver() {
        driver.quit();
    }

}
