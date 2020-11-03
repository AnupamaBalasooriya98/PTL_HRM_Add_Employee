package com.pragmatic.addEmployee;

import com.pragmatic.util.TestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class Base {
    public static WebDriver driver;
    public TestData data;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(data.url);

        // Login to the site
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(data.username);
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(data.password);
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

        // Navigate to 'Add Employee' page
        driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
        driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']")).click();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
