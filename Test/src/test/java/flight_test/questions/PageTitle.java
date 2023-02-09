package flight_test.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

import static flight_test.pageobjects.OrdersPage.FLIGHTS_LIST;

public class FlightPriceList implements Question<List<String>> {

    @Override
    public List<String> answeredBy(Actor actor) {
        return (List<String>) Text.ofEach(FLIGHTS_LIST).answeredBy(actor);
    }

    public static Question<List<String>> theFlightPrices() {
        return new FlightPriceList();
    }

}
