import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolsQA {

	private static WebDriver driver;
	private static String startPage = "http://www.bookdepository.com/";
	private static List<WebElement> sidebar;
	
	private static String[] colours = {"red","green","blue"};
	private static String[] lineStyles = {"solid","dotted","dashed","double","groove","ridge","inset","outset"};
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to(startPage);
		driver.manage().window().maximize();
		driver.navigate().refresh();
		
		
		// WORKS !!!!!!!!
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.id("book-search"));
		js.executeScript("arguments[0].style.border = '1px solid red'",element);

		
		// Use Upper level div to get a big WebElement 
		WebElement sidebar = driver.findElement(By.className("sidebar-section-content"));
		// Extract all of the Links into a list
		List<WebElement> sidebarLinks = sidebar.findElements(By.tagName("a"));
		
		//for(int i = 0;i < sidebarLinks.size();i++){
		while(true){
			//System.out.println("Sidebar element css Value " + i + " = " + sidebarLinks.get(i).getCssValue("border"));
				js.executeScript(getBorderStyle(),sidebarLinks.get((int) (Math.random() * sidebarLinks.size())));
			//js.executeScript("arguments[0].style.border = '1px solid #006400'",sidebarLinks.get(i));
			try{
				Thread.sleep(500);
			} catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		//	js.executeScript("arguments[0].style.border = 'none'",sidebarLinks.get(i));
		}
	}
	public static String getBorderStyle(){
		String style = lineStyles[(int) (Math.random() * lineStyles.length)];
		String colour = Integer.toHexString((int) (Math.random() * 16777215));
		int width = (int) (Math.random() * 10);
		System.out.println("arguments[0].style.border = '" + width + "px" + " " + style + " " + "#" + colour + "'");
		return "arguments[0].style.border = '" + width + "px" + " " + style + " " + "#" + colour + "'";
	}
}
