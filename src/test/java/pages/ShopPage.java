package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {

    public ShopPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
//        WebDriverWait wait = new WebDriverWait(driver, 5);
    }

    @FindBy(how = How.XPATH, using = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")
    private WebElement signIn;

    @FindBy(how = How.XPATH, using = "//input[@id='email']")
    private WebElement userEmail;

    @FindBy(how = How.XPATH, using = "//input[@id='passwd']")
    private WebElement userPassword;

    @FindBy(how = How.XPATH, using = "//button[@id='SubmitLogin']")
    private WebElement logIn;

    @FindBy(how = How.CSS, using = "a[title='Women']")
    private WebElement customerGroup;

    @FindBy(how = How.LINK_TEXT, using = "Dresses")
    private WebElement department;

    @FindBy(how = How.LINK_TEXT, using = "Casual Dresses")
    private WebElement dressCode;

    @FindBy(how = How.CSS, using = "img[alt='Printed Dress']")
    private WebElement product;

    @FindBy(how = How.CSS, using = "button[class='exclusive'][name='Submit']")
    private WebElement addToCart;

    @FindBy(how = How.XPATH, using = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")
    private WebElement checkOut1;

    @FindBy(how = How.CSS, using = "a[title='Proceed to checkout'][style='']")
    private WebElement checkOut2;

    @FindBy(how = How.CSS, using = "button[name='processAddress']")
    private WebElement checkAddress;

    @FindBy(how = How.CSS, using = "input[id='cgv'][type='checkbox'][value='1']")
    private WebElement agreeOnTerms;

    @FindBy(how = How.CSS, using = "button[type='submit'][name='processCarrier']")
    private WebElement checkOut3;

    @FindBy(how = How.XPATH, using = "//a[@class='cheque']")
    private WebElement payCheck;

    @FindBy(how = How.XPATH, using = "//p/span[@id='amount']")
    private WebElement orderAmount;

    @FindBy(how = How.XPATH, using = "//button[@class='button btn btn-default button-medium']" +
            "/span[text()='I confirm my order']")
    private WebElement confirmOrder;

    @FindBy(how = How.XPATH, using = "//p[@class='alert alert-success']")
    private WebElement orderComplete;

    @FindBy(how = How.XPATH, using = "//a[@title='Back to orders']")
    private WebElement backToOrder;

    @FindBy(how = How.XPATH, using = "//td[@class='history_price']/span")
    private WebElement orderPrice;

    @FindBy(how = How.XPATH, using = "//*[@id='header']/div[2]/div/div/nav/div[2]/a")
    private WebElement logOff;

    public void signIn() {
        this.signIn.click();
    }

    public void inputEmail(String userEmail) {
        this.userEmail.sendKeys(userEmail);
    }

    public void inputPassWrd(String userPassword) {
        this.userPassword.sendKeys(userPassword);
    }

    public void logIn() {
        this.logIn.click();
    }

    public void selectGroup() {
        this.customerGroup.click();
    }

    public void selectDepartment() {
        this.department.click();
    }

    public void selectDressCode() {
        this.dressCode.click();
    }

    public void selectProduct() {
        this.product.click();
    }

    public void addToCart() {
        this.addToCart.click();
    }

    public void checkOut_1() {
        this.checkOut1.click();
    }

    public void checkOut_2() {
        this.checkOut2.click();
    }

    public void checkDeliveryBillAddress() {
        this.checkAddress.click();
    }

    public void agreeOnTerms() {
        this.agreeOnTerms.click();
    }

    public void checkOut_3() {
        this.checkOut3.click();
    }

    public void selectPayCheck() {
        this.payCheck.click();
    }

    public String getOrderAmount() {
        return (this.orderAmount.getText());
    }

    public void userConfirmOrder() {
        this.confirmOrder.click();
    }

    public String completeOrderMsg() {
        return (this.orderComplete.getText());
    }

    public void backToOrder() {
        this.backToOrder.click();
    }

    public String getTotalPrice() {
        return (this.orderPrice.getText());
    }

    public void logOff() {
        this.logOff.click();
    }


}
