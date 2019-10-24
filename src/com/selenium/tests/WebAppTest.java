package com.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebAppTest {
	
	@Test
	public void loginTest() {
		WebDriver driver = new HtmlUnitDriver(true);
		driver.get("http://52.66.207.5:8080/webapp");
		driver.findElement(By.id("username")).sendKeys("swastik");
		driver.findElement(By.id("password")).sendKeys("swastik");
		driver.findElement(By.xpath("//button[text()='Click Me']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//font")).getText(), "LOGIN SUCCESSFUL");
	}
}
