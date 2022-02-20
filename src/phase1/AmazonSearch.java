package phase1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		//Launch Website
		driver.get("https://www.amazon.in/");
		
		//Maximize window
		driver.manage().window().maximize();

		//Wait for browser to load - implicit
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		
		WebElement SearchInput=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		SearchInput.sendKeys("Iphone12");
		
		WebElement Search=driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		Search.click();
		
		List<WebElement> Results=driver.findElements(By.xpath("//a/span[contains(text(),'Apple iPhone 12')]"));
		System.out.println("Count: "+Results.size());
		
		List<WebElement> Name=driver.findElements(By.xpath("//a/span[@class='a-size-medium a-color-base a-text-normal']"));
	
		for(int i=0;i<Name.size();i++) {
			
			if(Name.get(i).getText().toLowerCase().contains("apple iphone 12")) {
				
				List<WebElement> Price=driver.findElements(By.xpath("//span[@class='a-price-whole']"));	
				System.out.println("IPhone Name :"+Name.get(i).getText() + " IPhone Price:"+Price.get(i).getText() );
			}
			
		}
		
	}

}
