package HW_02_eshop.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static HW_02_eshop.pagepobjects.EShopWebowkyCzPage.CATEGORY_LINKS;

public class BrowseCategory implements Task {

    private final String category;

    protected BrowseCategory(String category) {
        this.category = category;
    }

    public static BrowseCategory called(String category) {
        return Instrumented.instanceOf(BrowseCategory.class).withProperties(category);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // attempt to navigate to given category in the menu
        actor.attemptsTo(
                Click.on(CATEGORY_LINKS.called(category))
        );
    }
}
