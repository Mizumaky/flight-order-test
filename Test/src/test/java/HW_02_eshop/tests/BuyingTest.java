package HW_02_eshop.tests;

import HW_02_eshop.pagepobjects.EShopWebowkyCzPage;
import HW_02_eshop.questions.ItemsInCart;
import HW_02_eshop.questions.ItemsInCategory;
import HW_02_eshop.tasks.AddToCart;
import HW_02_eshop.tasks.BrowseCategory;
import HW_02_eshop.tasks.NavigateTo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItem;

// resources: https://serenity-bdd.github.io/docs/screenplay/screenplay_fundamentals
// https://www.infoq.com/articles/Beyond-Page-Objects-Test-Automation-Serenity-Screenplay/
// https://www.baeldung.com/serenity-screenplay

public class BuyingTest {
    // create actor
    Actor pepa = Actor.named("Pepa");

    // init webdriver and page object
    @Managed
    private WebDriver browser;
    EShopWebowkyCzPage eShopWebowkyCzPage;

    // setup actor
    @BeforeEach
    public void setupActor() {
        givenThat(pepa).can(BrowseTheWeb.with(browser));
    }

    // test browsing a category
    @Test
    public void browseCategory() {
        String category = "T-shirts";
        String sampleItem = "Tričko - krátké rukávy";

        givenThat(pepa).wasAbleTo(NavigateTo.eshopHomepage());
        when(pepa).attemptsTo(BrowseCategory.called(category));
        then(pepa).should(seeThat(ItemsInCategory.displayed(), hasItem(sampleItem)));
        // hamcrast matcher to check if the list contains the item
    }

    // test adding the first item in a category to cart
    @Test
    public void addItemToCart() {
        String category = "T-shirts";

        givenThat(pepa).wasAbleTo(NavigateTo.eshopHomepage());
        when(pepa).attemptsTo(BrowseCategory.called(category));
        String firstItemName = ItemsInCategory.displayed().answeredBy(pepa).get(0);
        // Note: at first, I was thinking about http://serenity-bdd.info/docs/serenity/#_storing_data_between_steps
        when(pepa).attemptsTo(AddToCart.firstItem());
        when(pepa).attemptsTo(NavigateTo.eshopCart());
        then(pepa).should(seeThat(ItemsInCart.displayed(), contains(firstItemName)));
        // hamcrast matcher to check if the list is equal to the list with the item
    }
}
