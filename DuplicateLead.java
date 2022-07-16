package assignmentWeek2Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Launch the WDM for the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Accessing the url and logging in 
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		WebElement logout = driver.findElement(By.className("decorativeSubmit"));
		String attribute = logout.getAttribute("Value");

		// Login validation
		if (attribute.equals("Logout"))
		{
			System.out.println("Logged in Successfully");
		}
		else {
			System.out.println("Not Loggedin");
		}

		// Navigate to CRM/SFA page
		driver.findElement(By.linkText("CRM/SFA" )).click();

		//Navigate to to create lead page
		driver.findElement(By.linkText("Leads" )).click();
		driver.findElement(By.linkText("Create Lead" )).click();

		//Entering the value for the fields
		//first Name , Last name , company, first name local, department , email id and description
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("ABC");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("PRABHU");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("SHANMUGAM");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("AAA");
		driver.findElement(By.name("departmentName")).sendKeys("IT");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Assignment for the week2. day1");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("TEST@Gmail.com");

		// Selecting the state dropdonw
		WebElement State = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select select = new Select(State);
		select.selectByVisibleText("New York");

		// Click on submit button
		driver.findElement(By.className("smallSubmit")).click();

		//Validation part with page title
		String title = driver.getTitle();
		System.out.println(title);
		if (title.equals("View Lead | opentaps CRM"))
		{
			System.out.println("Lead creted sucessfully");
		}
		else {
			System.out.println("Not Created");
		}

		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.className("smallSubmit")).click();
		String title2 = driver.getTitle();

		if (title2.equals("View Lead | opentaps CRM"))
		{
			System.out.println("Lead Duplication creted sucessfully");
		}
		else {
			System.out.println("Lead Duplication creation failed");
		}
	}
}
