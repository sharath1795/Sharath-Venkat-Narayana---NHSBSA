package stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.jsoup.select.Evaluator.IsEmpty;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JobSearch_SortResults_Test {
	public static WebDriver driver;
	
	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws IOException
	{
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);
	}
	
	@Given("Chrome browser is launched")
	public void Chrome_browser_is_launched() throws Exception {
		ChromeOptions chromeOptions = new ChromeOptions();
		
//		WebDriverManager.chromedriver().setup();
//		chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking","enable-automation"));
//		chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
//		//chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
//		chromeOptions.addArguments("--remote-allow-origins=*");
//	    chromeOptions.addArguments("chrome.switches", "--disable-extensions --disable-extensions-file-access-check --disable-extensions-http-throttling --disable-infobars");
//	    chromeOptions.addArguments("--disable-extensions");
//	    chromeOptions.addArguments("test-type");
//	    Map<String, Object> prefs = new HashMap<String, Object>();
//	    prefs.put("credentials_enable_service", false);
//	    prefs.put("profile.password_manager_enabled", false);
//	    chromeOptions.setExperimentalOption("prefs", prefs);
//	    chromeOptions.addArguments("--window-size=1920,1080");
//	    chromeOptions.addArguments("--start-maximized");
//	    chromeOptions.addArguments("--headless");
		
		driver = new ChromeDriver(chromeOptions);
		System.out.println("Chrome Browser is launched...");

		driver.manage().window().maximize();
	}
	
	@Given("Firefox browser is launched")
	public void Firefox_browser_is_launched() throws Exception {	
		WebDriverManager.firefoxdriver().setup();

		driver = new FirefoxDriver();
		System.out.println("Firefox Browser is launched...");

		driver.manage().window().maximize();
	}

	@Given("I visit the NHS Jobs website")
	public void i_visit_the_nhs_jobs_website() throws Exception {
		System.out.println("Running: i_visit_the_nhs_jobs_website() function...");
		
		driver.get("https://www.jobs.nhs.uk/candidate/search");
		System.out.println("Website is launched...");
		
		takeSnapShot(driver, "Screenshots/001_launch.png"); 
		
	}

	@Given("Search page is loaded")
	public void search_page_is_loaded() {
		Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Search for jobs in the NHS']")).isDisplayed());

	}

	@When("I enter Job Title and Location and Distance information")
	public void i_enter_job_title_and_location_and_distance_information() throws IOException {
		driver.findElement(By.xpath("//input[@id='keyword']")).sendKeys("Software Test Engineer");
		driver.findElement(By.xpath("//input[@id='location']")).sendKeys("London");
		
		driver.findElement(By.xpath("//select[@class='nhsuk-select nhsuk-grid-column-full select-width100' and @id='distance']")).click();
		driver.findElement(By.xpath("//*[text()='+20 Miles']")).click();
		//driver.findElement(By.xpath("")).sendKeys("Software Test Engineer");
		takeSnapShot(driver, "Screenshots/002_form_filled.png"); 

	}
	
	
	
	@When("I enter {string} and {string} and {string} information")
	public void i_enter_and_and_information(String jobTitle, String location, String distance) {
		driver.findElement(By.xpath("//input[@id='keyword']")).sendKeys(jobTitle);
		driver.findElement(By.xpath("//input[@id='location']")).sendKeys(location);
		
		driver.findElement(By.xpath("//select[@class='nhsuk-select nhsuk-grid-column-full select-width100' and @id='distance']")).click();
		driver.findElement(By.xpath("//*[text()='"+distance+"']")).click();
	}
	
	
	
	
	

	@When("Search button is clicked")
	public void search_button_is_clicked() {
		driver.findElement(By.xpath("//input[@class='nhsuk-button']")).click();
	}

	@Then("Search Results are displayed")
	public void search_results_are_displayed() {
		Assert.assertTrue(driver.findElement(By.xpath("//span[@data-test='search-results-count']")).isDisplayed());
	}

	@Then("The Results are sorted by Date Posted")
	public void the_results_are_sorted_by_date_posted() throws ParseException, IOException {
		driver.findElement(By.xpath("//select[@id='sort']")).click();
		driver.findElement(By.xpath("//option[text()='Date Posted (newest)']")).click();
		List<WebElement> searchResultsList = driver.findElements(By.xpath("//li[@class='nhsuk-list-panel search-result nhsuk-u-padding-3']"));
		System.out.println("Results: "+searchResultsList.size());
		List<String> datePosted = new ArrayList<String>();
		List<Date> datesList = new ArrayList<Date>();
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
		for(int i=0;i<searchResultsList.size();i++) {
			driver.findElements(By.xpath("//li[@class='nhsuk-list-panel search-result nhsuk-u-padding-3']")).get(i).click();
			takeSnapShot(driver, "Screenshots/00"+(i+3)+"_search_result_clicked.png"); 

			driver.findElement(By.xpath("(//li[@class='nhsuk-list-panel search-result nhsuk-u-padding-3'])["+(i+1)+"]//a[@data-test='search-result-job-title']")).click();
			datePosted.add(i, driver.findElement(By.xpath("(//h3[@id='date_posted_heading'])[2]/..//p[1]")).getText().toString());
			datesList.add(i, formatter.parse(datePosted.get(i)));
			System.out.println("Date posted: "+datesList.get(i));

			driver.navigate().back();
		}
		
		if(datesList.isEmpty()||datesList.size()==1) {
			System.out.println("Date listed is sorted...");
		}
		
		Iterator<Date> iterator = datesList.iterator();
		Date current, previous = iterator.next();
		while (iterator.hasNext()) {
			current = iterator.next();
			if(previous.before(current)) {
				System.out.println("Dates are not sorted...");
			}
			previous = current;
		}
		System.out.println("Dates are sorted by DatePosted...");
	}

	@AfterAll
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
	
}
