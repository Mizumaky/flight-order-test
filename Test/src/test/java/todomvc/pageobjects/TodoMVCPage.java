package todomvc.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://todomvc.com/examples/react/")
public class TodoMVCPage extends PageObject {

    public static Target NEW_TODO_FIELD =
            Target.the("New Todo Field").locatedBy(".new-todo");

    public static final Target LIST_ITEMS = Target
            .the("List of todo items")
            .locatedBy(".todo-list li");
}
