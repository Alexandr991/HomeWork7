package steps;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

public class FindElementCarMarket {
    private final SelenideElement carMarket = $x("//span[@class='b-main-navigation__text' and text()='Автобарахолка']");

    @And("Наводим курсор на пункт Автобарахолка")
    public void FindElement() {
        actions().moveToElement(carMarket).perform();
    }

    @Then("Проверяем, что появилось подменю, отображающее категории деления: по ценам, по городам, по моделям.")
    public void checkMenu() {
        ArrayList<String> itemsInMenu = new ArrayList<>();
        itemsInMenu.add("Цена с НДС");
        itemsInMenu.add("Авто до 4000 р.");
        itemsInMenu.add("Авто до 10000 р.");
        itemsInMenu.add("Минск");
        itemsInMenu.add("Гомель");
        itemsInMenu.add("Могилев");
        itemsInMenu.add("Витебск");
        itemsInMenu.add("Гродно");
        itemsInMenu.add("Брест");
        itemsInMenu.add("Audi");
        itemsInMenu.add("BMW");
        itemsInMenu.add("Citroen");
        itemsInMenu.add("Ford");
        itemsInMenu.add("Mazda");
        itemsInMenu.add("Mercedes-Benz");
        ElementsCollection items = Selenide.$$x("//a[text()='Автобарахолка']/../..//div[contains(@class, 'grid')]//span[contains(@class, 'sign')]");
        Assertions.assertThat(items.containsAll(itemsInMenu)).isTrue();
    }
}
