package steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.When;

public class WaitPageLoading {
    @When("Заходим на главную страницу Онлайнера и ждём загрузку страницы.")
    public void WaitPageLoading() {
        try {
            Selenide.webdriver().wait(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
