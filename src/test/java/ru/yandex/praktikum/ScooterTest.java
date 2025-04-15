package ru.yandex.praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class ScooterTest {

    @Rule
    public final DriverFactory driverFactory = new DriverFactory();

    @Test
    public void test() {
        WebDriver driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.clickOnStatus();
        mainPage.enterOrderId("1234");
        mainPage.clickOnGo();
        mainPage.checkErrorOrder();
    }
}
