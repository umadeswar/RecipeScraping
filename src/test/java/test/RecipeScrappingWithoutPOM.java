package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class RecipeScrappingWithoutPOM {
	WebDriver driver=null;
	@Test

	public void recipeScrappingSouthIndian() throws Exception {
	//set system Property here

	driver = new ChromeDriver();

	driver.get("https://www.tarladalal.com/");
	driver.findElement(By.xpath("//div[@id='search']/input[@id='ctl00_txtsearch']")).sendKeys("Healthy Recipes");
	driver.findElement(By.xpath("//div[@id='search']/input[@type='submit']")).click();
	driver.findElement(By.xpath("//div[@class='menucontainer_div']")).click();
	driver.findElement(By.xpath("//article[@class='rcc_recipecard'][1]//div[@class='rcc_rcpcore']/span[1]/a")).click();
}
}