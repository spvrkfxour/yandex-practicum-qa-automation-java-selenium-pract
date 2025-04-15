package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class MainPage {
    private final WebDriver driver;

    private final By imageNotFound = By.cssSelector("img[alt='Not found']");
    private final By buttonGo = By.className("Header_Button__28dPO");
    private final By buttonStatus = By.className("Header_Link__1TAG7");
    private final By inputOrderId = By.className("Input_Input__1iN_Z");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(EnvConf.URL);
    }

    public void clickOnStatus() {
        driver.findElement(buttonStatus).click();
    }

    public void enterOrderId(String value) {
        driver.findElement(inputOrderId).sendKeys(value);
    }

    public void clickOnGo() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConf.EXPLICIT_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(buttonGo));
        driver.findElement(buttonGo).click();
    }

    public void checkErrorOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConf.EXPLICIT_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(imageNotFound));
        assertTrue(driver.findElement(imageNotFound).isDisplayed());
    }
}
