package com.pragmatic.addEmployee;

import com.pragmatic.util.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddEmployee extends Base {
    public TestData data;

    // TC_HRM_AE-001: Fill the full form with valid details
    @Test
    public void fillTheFullFormWithValidDetails() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(data.firstname);
        driver.findElement(By.xpath("//input[@id='middleName']")).sendKeys(data.middlename);
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(data.lastname);
        // Upload photograph
        WebElement uploadElement = driver.findElement(By.xpath("//input[@id='photofile']"));
        uploadElement.sendKeys(data.photograph);

        driver.findElement(By.xpath("//input[@id='chkLogin']")).click();
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(data.username);
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(data.emp_password);
        driver.findElement(By.xpath("//input[@id='re_password']")).sendKeys(data.emp_password);
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();

        driver.wait(5000);

        // Verify it logs out
        String actual = driver.findElement(By.xpath("//div[@id='logInPanelHeading']")).getText();
        Assert.assertEquals(actual, "LOGIN Panel");

        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(data.emp_username);
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(data.emp_password);
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

        // Verify it can login using created username and password
        String actualWelcome = driver.findElement(By.xpath("//a[@id='welcome']")).getText();
        Assert.assertEquals(actualWelcome, "Welcome HJPotter");
    }
}
