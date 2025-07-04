package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	WebDriver driver;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuBtn;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void performLogout() {
        menuBtn.click();
        try {
            Thread.sleep(1000); // beri waktu agar menu tampil
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logoutLink.click();
    }
}
