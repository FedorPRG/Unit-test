package seminars.five;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class SeleniumTest {

    @Test
    void seleniumTest() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.google.com");
        WebElement webElement = webDriver.findElement(By.name("q"));
        webElement.sendKeys("Selenium");
        webElement.submit();
        WebElement selenium = webDriver.findElement(By.tagName("cite"));
        assertThat(selenium.getText()).isEqualTo("https://www.selenium.dev");
        Thread.sleep(5000);
        webDriver.quit();
    }

    @Test
    void autorizationTest(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.saucedemo.com");
        WebElement nameElement = webDriver.findElement(By.id("user-name"));
        nameElement.sendKeys("standard_user");
        WebElement passElement = webDriver.findElement(By.id("password"));
        passElement.sendKeys("secret_sauce");
        passElement.submit();

        WebElement citeElement = webDriver.findElement(By.className("title"));

        assertThat(citeElement.getText()).isEqualTo("Products");

        webDriver.quit();

    }

}
