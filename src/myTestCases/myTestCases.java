package myTestCases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases {

	String website = "https://codenboxautomationlab.com/practice/";
	WebDriver driver = new ChromeDriver();

	Random rand = new Random();

	@BeforeTest

	public void mySetup() {
		driver.get(website);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@Test(enabled = false)

	public void RadioButton() {

		WebElement radioButtonDiv = driver.findElement(By.id("radio-btn-example"));
		radioButtonDiv.findElements(By.tagName("input")).get(0).click();

		boolean ActualResult = radioButtonDiv.findElements(By.tagName("input")).get(0).isSelected();

		boolean ExpetedResult = true;

		Assert.assertEquals(ActualResult, ExpetedResult);

	}

	@Test(enabled = false)
	public void AutomComplete() throws InterruptedException {

		String[] countries = { "jo", "sy", "ir" };
		int randomIndex = rand.nextInt(countries.length);
		String country = countries[randomIndex];

		driver.findElement(By.id("autocomplete")).sendKeys(country);
		Thread.sleep(1000);
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(3000);

		;
		System.out.println(driver.findElement(By.id("autocomplete")).getText());

	}

	@Test(enabled = false)

	public void SelectTag() throws InterruptedException {

		WebElement SelectTag = driver.findElement(By.id("dropdown-class-example"));
		Select mySelector = new Select(SelectTag);

		mySelector.selectByIndex(1);
		Thread.sleep(2000);
		mySelector.selectByVisibleText("Appium");
		;
		Thread.sleep(2000);

		mySelector.selectByValue("option3");

	}

	@Test(enabled = false)
	public void Checkboxes() {

		WebElement CheckboxDiv = driver.findElement(By.id("checkbox-example"));

		List<WebElement> AllCheckBoxes = CheckboxDiv.findElements(By.tagName("input"));

		for (int i = 0; i < AllCheckBoxes.size(); i++) {
			AllCheckBoxes.get(i).click();
			Assert.assertEquals(AllCheckBoxes.get(i).isSelected(), true);
		}
	}

	@Test(enabled = false)

	public void switchWindow() {
		WebElement openWindowButton = driver.findElement(By.id("openwindow"));
		openWindowButton.click();
		Set<String> handels = driver.getWindowHandles();

		List<String> allTabs = new ArrayList<>(handels);

		driver.switchTo().window(allTabs.get(1));

		System.out.println(driver.getTitle());
		driver.switchTo().window(allTabs.get(0));
		System.out.println(driver.getTitle());

	}

	@Test(enabled = false)

	public void switchTab() throws InterruptedException {

		driver.findElement(By.id("opentab")).click();

		Set<String> handels = driver.getWindowHandles();

		List<String> allTabs = new ArrayList<>(handels);

		driver.switchTo().window(allTabs.get(1));
		
		Thread.sleep(2000);
		
		System.out.println(driver.getTitle());
		driver.switchTo().window(allTabs.get(0));



	}
	
	@Test(enabled = false)
	
	public void AlertAndConfirm() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		
		js.executeScript("window.scrollTo(0,500)");
		
		String myname = "ahmad"; 
		driver.findElement(By.id("name")).sendKeys(myname);
		
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(2000);
		
		; 
		
		System.out.println(driver.switchTo().alert().getText().contains(myname));
		boolean ActualValue = driver.switchTo().alert().getText().contains(myname); 
		Assert.assertEquals(ActualValue, true);

		driver.switchTo().alert().dismiss();
	}
	
	@Test
	public void TheTable() {
		
	WebElement TheTable = 	driver.findElement(By.id("product"));
	
	List<WebElement> AllData = TheTable.findElements(By.tagName("td")); 
	
	System.out.println();
	driver.findElement(By.id("name")).sendKeys(AllData.get(0).getText());


//	for(int i = 0 ; i <AllData.size();i++) {
//		System.out.println(AllData.get(i).getText());
//	}
	}

}
