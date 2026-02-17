package myTestCases;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class TestData {
	
	String MyWebSite = "https://automationteststore.com/";
	
	
	WebDriver driver = new EdgeDriver();

	Random rand = new Random();

	String PasswordAndConfirmPassword = "Asd123!@#";
	
	
	String[] femaleNames = { "Noor", "Layan", "Reem", "Sara", "Maryam", "Tala", "Joud", "Haya", "Rana", "Dana" };

	String[] maleNames = { "ahmad", "omar", "firas", "motasem", "ali", "anas", "khaled", "suhiab", "rame",
			"ibraheem" };
	

	int randomindex1 = rand.nextInt(femaleNames.length);
	int randomindex2 = rand.nextInt(maleNames.length);

	String randomFirstName = femaleNames[randomindex1];
	String randomLastName = maleNames[randomindex2];
	
	String myname = "sara sara sara "; 
	
	int randomEmailNumber = rand.nextInt(5478);
	int randomEmailNumber2 = rand.nextInt(978);
	
	String TheEmail = randomFirstName + randomLastName + randomEmailNumber + randomEmailNumber2 + "@gmail.com";

	int randdomCountryIndex = rand.nextInt(1, 20);

	String NameForLoginAndSignUp = randomFirstName + randomLastName + randomEmailNumber + randomEmailNumber2 ; 

String LogoutLink = "https://automationteststore.com/index.php?rt=account/logout";

String ExpectedLogoutMessage = "You have been logged off your account."; 

boolean ExpectedLogoutValue = true ; 
	
	
	public void SetupMyTest() {
		
		driver.get(MyWebSite);

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); 
	}
}
