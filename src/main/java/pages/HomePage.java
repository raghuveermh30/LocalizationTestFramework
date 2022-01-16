package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ElementUtils;

public class HomePage {
    private WebDriver driver;
    private ElementUtils elementUtil;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtils(driver);
    }

    private WebElement getHeaderElement(String headerValue) {
        String headerXpathValue = "//a[contains(text(),'"+headerValue+"')]";
        return elementUtil.getElement("xpath", headerXpathValue);
    }

    public boolean isHeaderExist(String headerValue) {
        String header = getHeaderElement(headerValue).getText();
        System.out.println("Header value " + header);
        return getHeaderElement(headerValue).isDisplayed();
    }

    private WebElement getContactElement(String contactValue) {
        String contactXpathValue = "//a[contains(text(), '" + contactValue + "')]";
        return elementUtil.getElement("xpath", contactValue);
    }

    public boolean isContactExist(String contact) {
        String header = getHeaderElement(contact).getText();
        System.out.println("Conact " + header);
        return getHeaderElement(contact).isDisplayed();
    }

}
