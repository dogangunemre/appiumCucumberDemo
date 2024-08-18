import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.MalformedURLException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class StepDefinitions extends runAppiumDriver {

    ElementsParser parser = new ElementsParser();
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Given("Open Application")
    public void openAppication() throws MalformedURLException, InterruptedException {
        appiumDriver = createAppiumDriver();
    }

    @And("Swipe {int},{int},{int},{int},{int}")
    public void swipeCoordinates(int startX, int startY, int endX, int endY, int count) throws InterruptedException {

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        for (int i = 0; i < count; i++) {
            Sequence sequence = new Sequence(finger1, 1).addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY)).addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg())).addAction(new Pause(finger1, Duration.ofMillis(100))).addAction(finger1.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), endX, endY)).addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            appiumDriver.perform(Collections.singletonList(sequence));
        }
        logger.info(" {},{},{},{}- Swiped to coordinates.", startX, startY, endX, endY);
        waitBySecond(1);
    }

    @And("Wait {int} seconds")
    public void waitBySecond(int seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(seconds);
        logger.info("{} seconds waited", seconds);
    }

    @And("{string} verify if element exists")
    public void isExistElement(String elementKey) throws FileNotFoundException {
        assertTrue(findElementByXpath(elementKey).isDisplayed());
        logger.info("{}  element is on the page", elementKey);
    }

    @And("Find element by {string} clear and send keys {string}")
    public void sendKeysByKey(String elementKey, String text) throws FileNotFoundException {
        MobileElement webElement = findElementByXpath(elementKey);
        webElement.clear();
        webElement.setValue(text);
        logger.info("{} text was written to the {}  text ", elementKey, text);
    }

    @And("Find element by {string} clear")
    public void clearByKey(String elementKey) throws FileNotFoundException {
        MobileElement webElement = findElementByXpath(elementKey);
        webElement.clear();
        logger.info("{} area cleared", elementKey);
    }

    public MobileElement findElementByXpath(String elementKey) throws FileNotFoundException {
        String elementValue = parser.getElementKey(elementKey);
        return appiumDriver.findElementByXPath(elementValue);
    }

    public List<MobileElement> pFindElementsByXpath(String elementKey) throws FileNotFoundException {
        String elementValues = parser.getElementKey(elementKey);
        return appiumDriver.findElementsByXPath(elementValues);
    }

    @And("Find element by {string} and send keys {string}")
    public void sendKeysByKeyNotClear(String elementKey, String text) throws FileNotFoundException {
        findElementByXpath(elementKey).sendKeys(text);
        Assertions.assertEquals(findElementByXpath(elementKey).getAttribute("text"), text);
        logger.info("{} The value in the element and the {} value are the same ", elementKey, text);
    }

    @And("click {string}")
    public void iClick(String elementKey) throws FileNotFoundException {
        findElementByXpath(elementKey).click();
        logger.info("{} clicked ", elementKey);
    }

    @And("Click {string} Notification and Check the Notification")
    public void clickNotificationandChecktheNotification(String elementKey) throws FileNotFoundException, InterruptedException {
        String notificationText = (findElementByXpath("notification_text").getAttribute("text"));
        iClick(elementKey);
        waitBySecond(1);
        String notificationMessage = (findElementByXpath("notification_message").getAttribute("text"));
        Assertions.assertEquals(notificationText, notificationMessage);
        logger.info("{}  ve  {}  equals ", notificationText, notificationMessage);
    }

    @And("Check element {string} count {int}")
    public void elementNumberControl(String elementKey, int count) throws FileNotFoundException {
        List<MobileElement> elements = pFindElementsByXpath(elementKey);
        Assertions.assertEquals(elements.size(), count);
        logger.info("Check element {} count {} ", elementKey, count);
    }

    @And("long press {string}")
    public void longPress(String elementKey) throws FileNotFoundException {
        iClick(elementKey);
        MobileElement longPress = (MobileElement) new WebDriverWait(appiumDriver, 30).until(elementToBeClickable(MobileBy.AccessibilityId("Long press me")));
        new Actions(appiumDriver).clickAndHold(longPress).perform();
        logger.info("{} element was pressed for a long time ", elementKey);
    }

    @And("Randomly select and check the element with {string}")
    public void chooseRandomProductandControl(String elementKey) throws FileNotFoundException {

        List<MobileElement> productList = new ArrayList<>();
        List<MobileElement> elements = pFindElementsByXpath(elementKey);
        int elementsSize = elements.size();
        int height = appiumDriver.manage().window().getSize().height;
        for (int i = 0; i < elementsSize; i++) {
            MobileElement element = elements.get(i);
            int y = element.getCenter().getY();
            if (y > 0 && y < (height - 100)) {
                productList.add(element);
            }
        }
        Random random = new Random();
        int randomNumber;
        randomNumber = random.nextInt(productList.size());
        productList.get(randomNumber).click();
        assert findElementByXpath("message_text").getAttribute("text").contains(ListDialog.NumberWord.fromCodetoWord(randomNumber));
        logger.info("Randomly select and check the element with {}", elementKey);
    }

}



