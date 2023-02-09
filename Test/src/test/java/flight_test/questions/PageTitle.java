package flight_test.questions;

import flight_test.pageobjects.OrdersPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.TextContent;

import java.util.List;



public class PageTitle implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        // return the page title, which is a h1 element
        return TextContent.of(OrdersPage.PAGE_TITLE).answeredBy(actor);
    }

    public static Question<String> is() {
        return new PageTitle();
    }

}
