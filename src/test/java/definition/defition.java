package definition;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class defition {
	WebDriver driver;

	@Given("User berada di page Checkout")
	public void user_berada_di_page_Checkout() {
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");

		this.driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/payment-gateway/");

	}

	@When("Melakukan checkout")
	public void melakukan_checkout() {
		try {
			driver.findElement(By.xpath("//input[@value='Buy Now']")).click();
		} catch (WebDriverException e) {
		}
	}

	@When("User berada di page payment {string}")
	public void user_berada_di_page_payment(String string) {
		try {
			driver.findElement(By.xpath("//h2[normalize-space()='" + string + "']")).getText();
		} catch (WebDriverException e) {
		}
	}

	@When("User mengisi kartu kredit {long}")
	public void user_mengisi_kartu_kredit(long int1) {
		try {
			String cc = String.valueOf(int1);
			driver.findElement(By.xpath("//input[@id='card_nmuber']")).sendKeys(cc);
		} catch (Exception e) {
		}
	}

	@When("User mengisi expired month {int}")
	public void user_mengisi_expired_month(int int1) {
		try {
			String cc = String.valueOf(int1);
			WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
			month.click();
			month.sendKeys(cc);
		} catch (WebDriverException e) {
		}
	}

	@When("User mengisi expired year cc {int}")
	public void user_mengisi_expired_year_cc(int int1) {
		try {
			WebElement years = driver.findElement(By.xpath("//select[@id='year']"));
			years.click();
			driver.findElement(By.xpath("//option[@value='"+int1+"']")).click();
		} catch (WebDriverException e) {
		}
	}

	@When("User mengisi CVVcode {int}")
	public void user_mengisi_CVVcode(int int1) {
		try {
			String cc = String.valueOf(int1);
			WebElement ccv = driver.findElement(By.xpath("//input[@id='cvv_code']"));
			ccv.sendKeys(cc);
		} catch (WebDriverException e) {
		}
	}

	@When("User melaukukan payment")
	public void user_melaukukan_payment() {
		try {
			WebElement pay = driver.findElement(By.xpath("//input[@name='submit']"));
			pay.click();
		} catch (WebDriverException e) {
		}
	}

	@Then("User mendapatkan validasi {string}")
	public void user_mendapatkan_validasi(String string) {
		try {
			String pay = driver.findElement(By.xpath("//h2[normalize-space()='Payment successfull!']")).getText();
			assertEquals(pay, string);
			driver.close();
		} catch (WebDriverException e) {
		}
	}

	@Then("User mendapatkan notifikasi alert {string}")
	public void user_mendapatkan_notifikasi_alert(String string) {
		Alert alert = driver.switchTo().alert();
		String actual = alert.getText();
		assertEquals(actual,string);
		alert.accept();
		driver.close();
	}

}
