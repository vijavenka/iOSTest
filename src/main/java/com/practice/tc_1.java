package com.practice;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.util.HashMap;

public class tc_1 extends Capabilities{

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        IOSDriver<IOSElement> driver = setup();

        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@value='Text Entry']")).click();
        driver.findElement(By.className("XCUIElementTypeTextField")).sendKeys("Hello");
        driver.findElementByAccessibilityId("OK").click();

        driver.navigate().back();

        /*Dimension size = driver.manage().window().getSize();
        int x = size.getWidth() / 2;
        int starty = (int)(size.getHeight() * 0.60);
        int endy = (int)(size.getHeight() * 0.10);
        driver.swipe(x,starty, endy, 2000);*/

        driver.findElementByAccessibilityId("Steppers").click();
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Increment']")).click();
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Increment']")).click();
        System.out.println("Twice increment count : " + driver.findElements(By.className("XCUIElementTypeStaticText")).get(0).getText());
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Decrement']")).click();
        System.out.println("One after decrement count : " + driver.findElements(By.className("XCUIElementTypeStaticText")).get(0).getText());
        System.out.println("Custom label to display : " + driver.findElements(By.xpath("//XCUIElementTypeOther[@name='CUSTOM']")).get(1).getText());

        driver.navigate().back();

        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Picker View']")).click();
        driver.findElementByAccessibilityId("Green color component value").sendKeys("210");
        driver.findElements(By.className("XCUIElementTypePickerWheel")).get(0).sendKeys("50");
        driver.findElement(By.xpath("//XCUIElementTypePickerWheel[@name='Blue color component value']")).sendKeys("160");

        driver.navigate().back();

        //scroll
        /*RemoteWebElement parent = (RemoteWebElement)driver.findElement(By.xpath("//XCUIElementTypeStaticText")); //identifying the parent Table
        String parentID = parent.getId();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("element", parentID);
    // Use the predicate that provides the value of the label attribute
        scrollObject.put("predicateString", "label == 'Search Bars'");
        driver.executeScript("mobile:scroll", scrollObject);  // scroll to the target element

        driver.findElementByAccessibilityId("Search Bars").click();*/
        Thread.sleep(4000);
    }
}
