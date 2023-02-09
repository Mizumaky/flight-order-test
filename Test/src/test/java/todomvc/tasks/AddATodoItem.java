package todomvc.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.ui.InputField;

import static org.openqa.selenium.Keys.RETURN;
import static todomvc.pageobjects.TodoMVCPage.*;;

public class AddATodoItem implements Task {

    private final String thingToDo;

    protected AddATodoItem(String thingToDo) {
        this.thingToDo = thingToDo;
    }

    public static AddATodoItem called(String thingToDo) {
        return Instrumented.instanceOf(AddATodoItem.class)
                .withProperties(thingToDo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(thingToDo).into(NEW_TODO_FIELD),
                Hit.the(RETURN).keyIn(NEW_TODO_FIELD)
        );
    }
}
