package todomvc;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import todomvc.pageobjects.TodoMVCPage;
import todomvc.tasks.AddATodoItem;
import todomvc.tasks.StartWith;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

import static org.hamcrest.CoreMatchers.hasItem;
import static todomvc.pageobjects.TodoMVCPage.LIST_ITEMS;
import static todomvc.questions.TodoItemsList.*;

@ExtendWith(SerenityJUnit5Extension.class)
public class AddNewTodosTest {

    Actor james = Actor.named("James");

    @Managed
    private WebDriver theBrowser;

    TodoMVCPage todoMVCPage;

    @BeforeEach
    public void setupActor() {
        givenThat(james).can(BrowseTheWeb.with(theBrowser));
    }

    @Test
    public void addATodoItem() {
//        Open.browserOn().thePageNamed("https://todomvc.com/examples/react/");
        james.attemptsTo(Open.browserOn().the(todoMVCPage));
        givenThat(james).wasAbleTo(AddATodoItem.called("Buy some milk"));
    }

    @Test
    public void addATodoItemFinal() {
        String todoName = "Buy some milk";

        givenThat(james).wasAbleTo(StartWith.anEmptyTodoList());
        when(james).attemptsTo(AddATodoItem.called(todoName));
        then(james).should(seeThat(theDisplayedItems(), hasItem(todoName)));
    }

}
