package HW_02_eshop.tasks;

import HW_02_eshop.pagepobjects.EShopWebowkyCzPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.hamcrest.core.IsNull;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.Matchers.nullValue;

public class AddToCart implements Task {

    @Override
    @Step("{0} clicks on add to cart button on the first item")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(EShopWebowkyCzPage.FIRST_ITEM),
                MoveMouse.to(EShopWebowkyCzPage.FIRST_ITEM),
                Click.on(EShopWebowkyCzPage.FIRST_ITEM_ADD_TO_CART_BUTTON)
//                JavaScriptClick.on(EShopWebowkyCzPage.FIRST_ITEM_ADD_TO_CART_BUTTON)
        );
    }

    public static AddToCart firstItem() {
        return instrumented(AddToCart.class);
    }

}
