package com.library.steps;

import com.library.pages.BasePage;
import com.library.pages.BookPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import io.cucumber.java.en.*;

import java.util.List;

public class us03_step_definitions_AK  {

LoginPage loginPage = new LoginPage();

    BookPage bookPage = new BookPage();


    @Given("the {string} on the home page AK")
    public void the_on_the_home_page_AK(String username) {
        loginPage.login(username);
    }
    @When("the user navigates to {string} page AK")
    public void the_user_navigates_to_page_AK(String module) {
    bookPage.navigateModule(module);

    }
    @When("the user clicks book categories AK")
    public void the_user_clicks_book_categories_AK() {
        bookPage.mainCategoryElement.click();

    }
    @Then("verify book categories must match book_categories table from db AK")
    public void verify_book_categories_must_match_book_categories_table_from_db_AK() {
        List<String> actualResult = BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);
        actualResult.remove(0); // ALL (default option)
        System.out.println(actualResult);





    }





}
