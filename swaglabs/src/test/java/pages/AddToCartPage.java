package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import library.baseclass;

public class AddToCartPage extends baseclass{
	WebDriver driver;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartBtn;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;
    
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMSG;


    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddToCart() {
        addToCartBtn.click();
    }

    public boolean isItemAdded() {
        return cartBadge.isDisplayed();
    }

    public String getCartItemCount() {
        return cartBadge.getText(); // biasanya "1"
    }
}
