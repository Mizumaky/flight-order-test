package todomvc.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import todomvc.pageobjects.TodoMVCPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class StartWith implements Task {

    TodoMVCPage applicationHomePage;

    @Override
    @Step("{0} starts with an empty todo list")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().the(applicationHomePage));
    }

    public static StartWith anEmptyTodoList() {
        return instrumented(StartWith.class);
    }
}