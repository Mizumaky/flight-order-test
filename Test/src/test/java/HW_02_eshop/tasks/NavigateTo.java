package HW_02_eshop.tasks;

import HW_02_eshop.pagepobjects.EShopWebowkyCzCartPage;
import HW_02_eshop.pagepobjects.EShopWebowkyCzPage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;


public class NavigateTo {
    public static Task eshopHomepage() {
        return Task.where("{0} opens the Eshop home page",
                Open.browserOn().the(EShopWebowkyCzPage.class));
    }
    public static Task eshopCart() {
        return Task.where("{0} opens the Eshop cart page",
                Open.browserOn().the(EShopWebowkyCzCartPage.class));
    }
}

