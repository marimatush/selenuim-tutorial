package page.classes;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageFactory {
	WebDriver driver;
	
	@FindBy(xpath="//a[@aria-controls='search_form_product_selector_flights']")
	WebElement flightsTab;
	
	@FindBy(xpath="//a[@href='#FlightSearchForm_ROUND_TRIP']")
	WebElement roundTrip;
	
	@FindBy(xpath="//a[@href='#FlightSearchForm_ONE_WAY']")
	WebElement oneWay;
	
	@FindBy(xpath="//button[@data-stid='origin_select-menu-trigger']")
	WebElement leavingFromBtn;
	
	@FindBy(xpath="//button[@data-stid='destination_select-menu-trigger']")
	WebElement goingToBtn;
	
	@FindBy(xpath="//input[@data-stid='origin_select-menu-input']")
	WebElement leavingFromInput;
	
	@FindBy(xpath="//input[@data-stid='destination_select-menu-input']")
	WebElement goingToInput;
	
	
	public SearchPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickFlightsTab() {
		flightsTab.click();
	}
	
	public void clickRoundTrip() {
		roundTrip.click();
	}
	
	public void clickOneWay() {
		oneWay.click();
	}
	
	public void clickLeavingFromBtn() {
		leavingFromBtn.click();
	}
	
	public void clickGoingToBtn() {
		goingToBtn.click();
	}
	
	public void setLeavingFromInput(String city) {
		clickLeavingFromBtn();
		leavingFromInput.sendKeys(city);
	}
	
	public void setGoingToInput(String city) {
		clickGoingToBtn();
		goingToInput.sendKeys(city);
	}
}
