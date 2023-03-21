package steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

public class FindElementFlatAndHouseTest {
    private final SelenideElement flatAndHouse = $x("//span[@class='b-main-navigation__text' and text()='Дома и квартиры']");

    @When("Наводим курсор на пункт Дома и квартиры")
    public void findElement() {
        actions().moveToElement(flatAndHouse).perform();
    }

    @Then("Проверяем, что появилось подменю, отображающее категории: города, количество комнат, ценовой диапазон.")
    public void checkMenu() {
        ArrayList<String> itemsInMenu = new ArrayList<>();
        itemsInMenu.add("1-комнатные");
        itemsInMenu.add("2-комнатные");
        itemsInMenu.add("3-комнатные");
        itemsInMenu.add("4+-комнатные");
        itemsInMenu.add("Минск");
        itemsInMenu.add("Гомель");
        itemsInMenu.add("Могилев");
        itemsInMenu.add("Витебск");
        itemsInMenu.add("Гродно");
        itemsInMenu.add("Брест");
        itemsInMenu.add("До 30 000 $");
        itemsInMenu.add("30 000–80 000 $");
        itemsInMenu.add("От 80 000 $");
        ElementsCollection items = Selenide.$$x("//span[text()='Дома и квартиры']/../..//div[contains(@class, 'grid')]//span[contains(@class, 'sign')]");
        List<String> list = new ArrayList<>();
        for (SelenideElement x: items
        ) {
            list.add(x.getOwnText());
        }
        Assertions.assertThat(list.containsAll(itemsInMenu)).isTrue();
    }
}
