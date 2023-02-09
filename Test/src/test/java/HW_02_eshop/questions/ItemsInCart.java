package HW_02_eshop.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

import static HW_02_eshop.pagepobjects.EShopWebowkyCzCartPage.NAMES_OF_ITEMS_IN_CART;

public class ItemsInCart implements Question<List<String>> {

        @Override
        public List<String> answeredBy(Actor actor) {
            return (List<String>) Text.ofEach(NAMES_OF_ITEMS_IN_CART).answeredBy(actor);
        }

        public static Question<List<String>> displayed() {
            return new ItemsInCart();
        }

}

