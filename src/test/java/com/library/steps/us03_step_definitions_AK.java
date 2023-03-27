package com.library.steps;

import com.library.pages.BasePage;
import com.library.pages.BookPage;
import com.library.pages.LoginPage;
import io.cucumber.java.en.*;

public class us03_step_definitions_AK  {

LoginPage loginPage = new LoginPage();

    BookPage bookPage = new BookPage();


    @Given("the {string} on the home page")
    public void the_on_the_home_page_AK(String username) {
        loginPage.login(username);
    }
    @When("the user navigates to {string} page")
    public void the_user_navigates_to_page_AK(String module) {
    bookPage.navigateModule(module);

    }
    @When("the user clicks book categories")
    public void the_user_clicks_book_categories_AK() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db_AK() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }





}
