package ru.com.otus.step;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import ru.com.otus.page.MainPage;
import ru.com.otus.service.DriverService;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainPageStepdefs {
    @Autowired
    private MainPage mainPage;

    @Given("I open {int} topic")
    public void iOpenTopic(int index) {
        mainPage.openTopic(index - 1);
    }

    @Given("ATInfo is open")
    public void atinfoIsOpen() {
        mainPage.open();
    }

    @And("I click {string}")
    public void atinfoIsOpen(String buttonName) {
        mainPage.click(buttonName);
    }

    @Then("Login modal is visible")
    public void loginModalIsVisible() {
        assertThat(mainPage.getLoginBlock().getHeader().getText().toLowerCase(), equalTo("войти"));
    }
}
