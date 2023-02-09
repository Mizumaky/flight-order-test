package HW_02_eshop.pagepobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://e-shop.webowky.cz/objednavka-q")
public class EShopWebowkyCzCartPage extends PageObject {

    public static final Target NAMES_OF_ITEMS_IN_CART = Target
            .the("List of items in cart")
            .locatedBy("div#order-detail-content .cart_item .cart_description p");
}