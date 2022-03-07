package test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import objectRepository.RecipePageObjects;
import utils.ExcelUtils;

public class HealthRecipes {
	public static String category;
	WebDriver driver=null;

	@Test

	public void healthyRecipeScrappingSouthIndian() throws Exception {


		System.setProperty("webdriver.chrome.driver", "/Users/eswar/Documents/chromedriver");
		
		
		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("profile.managed_default_content_settings.images", 2);

		ChromeOptions op = new ChromeOptions();
		op.setExperimentalOption("prefs", prefs);
		 driver= new ChromeDriver(op);

		driver.get("https://www.tarladalal.com/");
		RecipePageObjects recipePageObj = new RecipePageObjects(driver);
		recipePageObj.textbox("Health");
		recipePageObj.search();
		recipePageObj.linkclick();
		
		
		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);
		ExcelUtils xlUtils= new ExcelUtils("files/HealthRecipes.xlsx");
		
		ArrayList<String> data = new ArrayList<String>();
		data.add("Title");
		data.add("Category");
		data.add("Ingredients");
		data.add("Method/Recipe Steps");
		data.add("Nutrient Values");
		data.add("Recipe image link");
		data.add("Link to the recipe");
		xlUtils.writeToExcel(data,"Sheet1",0);

		List<String> allLinksInRecipe =new ArrayList<String>();
		List<WebElement> links = recipePageObj.getAllLinksInRecipesPage();
		// js.executeScript("window.scrollBy(0,3000)");//"arguments[0].scrollIntoView();", links);
		for(int i=1;i<=links.size();i++)//links.size()
		{
			System.out.println(links.get(i));
			//links.get(i).click();

			recipePageObj.selectLinkInRecipeListPage(i);
			String ingredients = recipePageObj.getIngredients();


			String title = recipePageObj.getTitle();
			System.out.println(title);

			String recipeSteps = recipePageObj.getRecipeSteps();
			System.out.println(recipeSteps);


			String imageLink =recipePageObj.getImageLink() ;
			System.out.println(imageLink);

			String nutriotionVal =recipePageObj.getNutritionValues();
			System.out.println(nutriotionVal);

			String recipeLink= recipePageObj.getRecipeLink();
			System.out.println(recipeLink);

			data.clear();
			data.add(title);
			data.add(category);
			data.add(ingredients);
			data.add(recipeSteps);
			data.add(nutriotionVal);
			data.add(imageLink);
			data.add(recipeLink);
			xlUtils.writeToExcel(data,"Sheet1",i);

			driver.navigate().back();

		}
		driver.close();   

	}

}