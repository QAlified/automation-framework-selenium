package automation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class UIElement {
	
	private WebAutomator automator;
	private WebElement   element;
	
	public UIElement(WebAutomator automator, WebElement element) {
		this.automator = automator;
		this.element = element;
	}
	
	public WebElement getWebElement() {
		return this.element;
	}
	
	public void setText(String text) {
		this.element.sendKeys(text);
	}
	
	public void clear() {
		this.element.clear();
	}
	
	public void clearAndSetText(String text) {
		this.clear();
		this.setText(text);
	}
	
	public String getLink() {
		return this.element.getAttribute("href");
	}
	
	public void submit() {
		this.element.submit();
	}
		
	public void click() {
		this.element.click();
	}
	
	public boolean isSelected() {
		return this.element.isSelected();
	}
	
	public boolean isDisplayed() {
		return this.element.isDisplayed();
	}
	
	public boolean isEnabled() {
		return this.element.isEnabled();
	}
	
	public String getText() {
		return this.element.getText();
	} 
	
	public String getValue() {
		return this.element.getAttribute("value");
	}
	
	public UIElement findElementBy(By by) {
		return new UIElement(automator, this.element.findElement(by));
	}
	
	public List<UIElement> findElementsBy(By by) {
		List<UIElement> retorno = new ArrayList<>();
		List<WebElement> elementos = this.element.findElements(by);
		for(int i = 0; i < elementos.size(); i++) {
			retorno.add(new UIElement(automator, elementos.get(i)));
		}
		return retorno;
	}
	
	public void setTextWithActions(String text) {
		Actions actions = new Actions(this.automator.getDriver());
		actions.click(this.element)
			.sendKeys(this.element, text)
			.build()
			.perform();
	}
	
	private Select getSelect() {
		return new Select(this.element);
	}
	
	public void selectByValue(String value) {
		this.getSelect().selectByValue(value);
	}
	
	public void selectByIndex(Integer index) {
		this.getSelect().selectByIndex(index);
	}
	
	public void selectByVisibleText(String text) {
		this.getSelect().selectByVisibleText(text);
	}
	
	public void moveToElement() {
		Actions actions = new Actions(this.automator.getDriver());
		actions.moveToElement(this.element);
	}

}
