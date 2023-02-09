package flight_test.tests;

import HW_02_eshop.questions.ItemsInCategory;
import HW_02_eshop.tasks.BrowseCategory;
import HW_02_eshop.tasks.NavigateTo;
import flight_test.pageobjects.OrdersPage;
import flight_test.questions.FlightPriceList;
import flight_test.questions.PageTitle;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import todomvc.tasks.AddATodoItem;
import todomvc.tasks.StartWith;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.hasItem;
import static todomvc.questions.TodoItemsList.theDisplayedItems;

public class FlightOrderTest {
    Actor pepa = Actor.named("Pepa");

    // init webdriver and page object
    @Managed
    private WebDriver browser;
    OrdersPage ordersPage;

    // setup actor
    @BeforeEach
    public void setupActor() {
        givenThat(pepa).can(BrowseTheWeb.with(browser));
    }

    // test browsing flight orders
    @Test
    public void browseOrders() {
        pepa.attemptsTo(Open.browserOn().the(ordersPage));
        then(pepa).should(seeThat(PageTitle.is(), CoreMatchers.equalTo("Orders")));
    }
}
