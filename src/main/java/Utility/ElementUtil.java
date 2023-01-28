package Utility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);

	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public void doActSendkeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).build().perform();

	}

	public void doActClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).build().perform();
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public boolean doElementIsDispalyed(By locator) {
		return getElement(locator).isDisplayed();

	}

	public boolean doElementIsEnabled(By locator) {
		return getElement(locator).isEnabled();

	}

	public boolean doElementIsSelected(By locator) {
		return getElement(locator).isSelected();

	}

	public void doCheckElementIsPresent(By locator, int elementOccurence) {
		List<WebElement> element = getElements(locator);
		if (element.size() == elementOccurence) {
			System.out.println("elements are present");
		} else {
			System.out.println("elements are not present");
		}

	}

	public void doCheckElementIsPresent(By locator) {
		List<WebElement> element = getElements(locator);
		if (element.size() == 1) {
			System.out.println("element is present");
		} else {
			System.out.println("element not present");
		}

	}

	public String doGetAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

	public void doLinkClick(By locator, String linkName) {
		List<WebElement> list = getElements(locator);
		System.out.println(list.size());
		for (WebElement e : list) {
			String text = e.getText();
			System.out.println(text);
			if (text.trim().equalsIgnoreCase(linkName)) {
				e.click();
				break;
			}
		}

	}

	/********************** dropdown utils *********************************/

	public void doSelectDropdown(By locator, String textvalue) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionlist = select.getOptions();
		iterateDropDownSelect(optionlist, textvalue);
		doIsDropdownSelecetd(select, textvalue);
	}

	public void doSelectDropdownWithoutSelect(By locator, String textvalue) {
		List<WebElement> optionlist = getElements(locator);
		iterateDropDownSelect(optionlist, textvalue);
	}

	private void iterateDropDownSelect(List<WebElement> optionlist, String textvalue) {
		System.out.println(optionlist.size());
		for (WebElement e : optionlist) {
			String text = e.getText();
			if (text.equalsIgnoreCase(textvalue)) {
				e.click();
				break;
			}
		}
	}

	public boolean doSelectDropdownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
		return doIsDropdownSelecetd(select, index);
	}

	public boolean doSelectDropdownByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
		return doIsDropdownSelecetd(select, text);
	}

	public boolean doSelectDropdownByVisibleValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
		return doIsDropdownSelecetd(select, value);
	}

	public boolean doIsDropdownSelecetd(Select select, String expValue) {
		System.out.println(expValue + " :is selected");
		if (select.getFirstSelectedOption().getText().contains(expValue)) {
			return true;
		}
		return false;
	}

	public boolean doIsDropdownSelecetd(Select select, int expValue) {
		System.out.println(expValue + " :is selected");
		if (select.getFirstSelectedOption().getText().equals(expValue)) {
			return true;
		}
		return false;
	}

	/************************* Action classes utils *******************************/

	public void parentChildMenueHandle(By parent, By child) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parent)).build().perform();
		Thread.sleep(2000);
		getElement(child).click();

	}

	public int doContextClickItemsCount(By rightClick, By items) {
		return docontextClick(rightClick, items).size();
	}

	public void doClickRightContextClickItem(By rightClick, By items, String itemName) {
		Actions act = new Actions(driver);
		act.contextClick(getElement(rightClick)).build().perform();
		List<WebElement> clickmeoptions = getElements(items);
		System.out.println(clickmeoptions.size());
		for (WebElement e : clickmeoptions) {
			String text = e.getText();
			if (text.equalsIgnoreCase(itemName)) {
				e.click();
				break;
			}
		}
	}

	public List<String> docontextClick(By rightClick, By items) {
		List<String> clickmeOptionlist = new ArrayList<String>();
		Actions act = new Actions(driver);
		act.contextClick(getElement(rightClick)).build().perform();
		List<WebElement> clickmeoptions = getElements(items);
		System.out.println(clickmeoptions.size());
		for (WebElement e : clickmeoptions) {
			clickmeOptionlist.add(e.getText());
		}
		return clickmeOptionlist;

	}

	/******************************* wait utils ******************************/

	public Alert waitForJsAlert(long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(long timeout) {
		waitForJsAlert(timeout).accept();
	}

	public void dismissAlert(long timeout) {
		waitForJsAlert(timeout).dismiss();
	}

	public void alertSendKeys(long timeout, String value) {
		waitForJsAlert(timeout).sendKeys(value);
	}

	public String alertGetText(long timeout) {
		Alert alert = waitForJsAlert(timeout);
		String text = alert.getText();
		alert.accept();
		return text;
	}

	public void waitFrameByIdorName(String frameLocator, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	public void WaitFrameByIndex(int frameIndex, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}

	public void WaitFrameBylocator(By locator, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	public void WaitFrameByWebElement(WebElement frameElement, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}

	public boolean waitForUrlToBe(String url, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.urlToBe(url));
	}

	public boolean waitForUrlContains(String urlFraction, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.urlContains(urlFraction));
	}

	public String waitForTitleContains(long timeout, String titleFraction) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		if (wait.until(ExpectedConditions.titleContains(titleFraction))) {
			return driver.getTitle();
		}
		return null;
	}

	public String waitForTitleToBe(long timeout, String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		if (wait.until(ExpectedConditions.titleIs(title))) {
			return driver.getTitle();
		}
		return null;
	}

	public void waitForElementPresent(By locator, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void waitForElementPresent(By locator, long timeout, long timeInerval) {
		WebDriverWait wait = new WebDriverWait(driver, timeout, timeInerval);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement waitForElementVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForElementClickable(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void ClickWhenReady(By locator, int timeout) {
		waitForElementClickable(locator, timeout).click();
	}

	public List<WebElement> waitForAllElementsPresent(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

	}

	public List<String> getElementsTextList(By locator, int timeout) {
		List<WebElement> elist = waitForAllElementsPresent(locator, timeout);
		List<String> elelist = new ArrayList<String>();
		for (WebElement e : elist) {
			elelist.add(e.getText());
		}
		return elelist;
	}

	public void printElementTextList(By locator, int timeout) {
		List<WebElement> elist = waitForAllElementsPresent(locator, timeout);
		for (WebElement e : elist) {
			System.out.println(e.getText());
		}
	}
	public List<WebElement> waitForAllElementsVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

	}
	public List<String> getVisibleElementsTextList(By locator, int timeout) {
		List<WebElement> elist = waitForAllElementsVisible(locator, timeout);
		List<String> elelist = new ArrayList<String>();
		for (WebElement e : elist) {
			elelist.add(e.getText());
		}
		return elelist;
	}

	public void printVisibleElementTextList(By locator, int timeout) {
		List<WebElement> elist = waitForAllElementsVisible(locator, timeout);
		for (WebElement e : elist) {
			System.out.println(e.getText());
		}
	}

}
