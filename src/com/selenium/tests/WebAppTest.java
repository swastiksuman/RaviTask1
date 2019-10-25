package com.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class WebAppTest {
	
	@Test
	public void loginTest() {
		WebDriver driver = new HtmlUnitDriver(true);
		driver.get("http://13.233.124.116:8080/webapp");
		driver.findElement(By.id("username")).sendKeys("swastik");
		driver.findElement(By.id("password")).sendKeys("swastik");
		driver.findElement(By.xpath("//button[text()='Click Me']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//font")).getText(), "LOGIN SUCCESSFUL");
	}
	
	@Test
	public void invalidLoginTest() {
		WebDriver driver = new HtmlUnitDriver(true);
		driver.get("http://13.233.124.116:8080/webapp");
		driver.findElement(By.id("username")).sendKeys("swastik");
		driver.findElement(By.id("password")).sendKeys("ss");
		driver.findElement(By.xpath("//button[text()='Click Me']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//font")).getText(), "INVALID CREDENTIALS");
	}
	
	@Test
	public void dogsAPITest() {
		get("https://dog.ceo/api/breeds/image/random").then().statusCode(200);
	}
	
	@Test
	public void dogsAPITestCheckSuccessMessage() {
		get("https://dog.ceo/api/breeds/image/random").then().assertThat()
        .body("status", equalTo("success"));

	}
	@Test
	public void dogListAllBreeds() {
		get("https://dog.ceo/api/breeds/list/all").then().statusCode(200);	
	}
}
