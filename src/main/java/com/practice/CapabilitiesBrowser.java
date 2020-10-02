package com.practice;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CapabilitiesBrowser {

    static IOSDriver<IOSElement> driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.BROWSER_NAME,"safari");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.4");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone 6");

        //iOS version > 10.2
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        
        driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        driver.get("http://gmail.com");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("vijay.t@scaleupst.com");
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/span/span")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("candy*scaleup2");
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/div[2]")).click();
    }
}
