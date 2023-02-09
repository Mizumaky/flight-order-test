package HW_02_eshop.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

import static HW_02_eshop.pagepobjects.EShopWebowkyCzPage.ITEM_LINKS_IN_CATEGORY;

public class ItemsInCategory implements Question<List<String>> {

        @Override
        public List<String> answeredBy(Actor actor) {
            return (List<String>) Text.ofEach(ITEM_LINKS_IN_CATEGORY).answeredBy(actor);
        }

        public static Question<List<String>> displayed() {
            return new ItemsInCategory();
        }

}
