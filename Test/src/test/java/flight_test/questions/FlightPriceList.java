package todomvc.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

import static todomvc.pageobjects.TodoMVCPage.LIST_ITEMS;

public class TodoItemsList implements Question<List<String>> {

    @Override
    public List<String> answeredBy(Actor actor) {
//        return Text.of(LIST_ITEMS).answeredBy(actor);
        return (List<String>) Text.ofEach(LIST_ITEMS).answeredBy(actor);
    }

    public static Question<List<String>> theDisplayedItems() {
        return new TodoItemsList();
    }

}
