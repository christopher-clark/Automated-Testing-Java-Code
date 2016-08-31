import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase {

	public WebDriver wd;
	
	public PageBase() {
		// Modified Comment on BasePage
	}
	
	public void webElementSync(String value)
	{
		final String valueIn = value;
		
		(new WebDriverWait(wd, 10)).until(
			new ExpectedCondition<Boolean>()
			{ 
				public Boolean apply(WebDriver d)
				{
					return d.getTitle().toLowerCase().startsWith(valueIn.toLowerCase());
				} 
			}
		);
	}

}
