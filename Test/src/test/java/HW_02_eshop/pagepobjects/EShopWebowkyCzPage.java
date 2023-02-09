package HW_02_eshop.pagepobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://e-shop.webowky.cz/")
public class EShopWebowkyCzPage extends PageObject {

    public static final Target CATEGORY_LINKS = Target
            .the("List of category links in menu")
            .locatedBy(".sf-menu > li:nth-child(1) a");
            // ">" represents a direct child element
            // " " represents a child element in any level
            // ":" represent elements based on state information that is not contained in the document tree
            // eg "li:nth-child(1)" represents the first li element in the list
            // eg "a:visited" represents a link that has been visited
            // https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_Selectors
            // https://www.w3schools.com/cssref/css_selectors.php
            // https://www.toolsqa.com/selenium-webdriver/css-selectors-in-selenium/
            //
            // to test selectors, use $$("selector") in the browser console

    public static final Target ITEM_LINKS_IN_CATEGORY = Target
            .the("List of item links in category")
            .locatedBy(".product_list a.product-name");

    public static final Target FIRST_ITEM = Target
            .the("First item in category")
            .locatedBy(".product_list > li:nth-child(1)");

    public static final Target FIRST_ITEM_ADD_TO_CART_BUTTON = Target
            .the("Add to cart button of the first item in category")
            .locatedBy(".product_list > li:nth-child(1) a.ajax_add_to_cart_button");

//    public static final Target ADD_TO_CART_BUTTONS_IN_CATEGORY = Target
//            .the("Add to cart buttons of items in the current category")
//            .locatedBy(".product_list a.ajax_add_to_cart_button");

}