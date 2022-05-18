package com.cydeo.test.officeHours.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P02_Name {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com");

        driver.findElement(By.partialLinkText("Sign")).click();
        Thread.sleep(3000);


        String actualTitle = driver.getTitle();
        String expectedTitle = "Sign Up";


        if(actualTitle.equals(expectedTitle)){
            System.out.println("PASSED");
        }else {
            System.err.println("FAILED");
        }


        WebElement full_name = driver.findElement(By.name("full_name"));
        full_name.sendKeys("John Smith");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("john@cydeo.com");

        Thread.sleep(3000);
        WebElement signUpButton = driver.findElement(By.name("wooden_spoon"));
        signUpButton.click();

        actualTitle=driver.getTitle();

        if(actualTitle.equals("Signup Confirmation")){
            System.out.println("PASSED");
        }else {
            System.err.println("FAILED");
        }
        Thread.sleep(3000);


        driver.quit();

    }
}
