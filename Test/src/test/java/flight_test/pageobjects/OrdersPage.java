package flight_test.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("http://localhost/Orders")
public class OrdersPage extends PageObject {
    // target for flights list
    public static final Target FLIGHTS_LIST = Target
            .the("List of flights")
            .locatedBy("table#flights tbody tr");

    // target for page title string, which is a h1 element (locate using css selector)
    public static final Target PAGE_TITLE = Target
            .the("Page title")
            .located(By.ByCssSelector.cssSelector("h1:first-of-type"));
}
