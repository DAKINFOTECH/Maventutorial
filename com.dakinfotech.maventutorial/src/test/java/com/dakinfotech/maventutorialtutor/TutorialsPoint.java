package com.dakinfotech.maventutorialtutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TutorialsPoint {
	@Test
	public void test1(){
		WebDriver driver=new FirefoxDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.name("userName")).sendKeys("arund87@gmail.com");
		driver.findElement(By.name("password")).sendKeys("pass123");
		driver.findElement(By.name("login")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.quit();
	}

}
