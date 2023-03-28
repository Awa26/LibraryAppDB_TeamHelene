package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US03_StepDefs_TK {
    LoginPage loginPage = new LoginPage();

    BookPage bookPage = new BookPage();

    List<String> actualCategories;


    @Given("the {string} on the home page TK")
    public void the_on_the_home_page_TK(String username) {
        loginPage.login(username);
    }

    @When("the user navigates to {string} page TK")
    public void the_user_navigates_to_page_TK(String module) {
        bookPage.navigateModule(module);

    }

    @When("the user clicks book categories TK")
    public void the_user_clicks_book_categories_TK() {
        bookPage.mainCategoryElement.click();

    }

    @Then("verify book categories must match book_categories table from db TK")
    public void verify_book_categories_must_match_book_categories_table_from_db_TK() {
        actualCategories = BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);
        actualCategories.remove(0);
        System.out.println("actualCategories = " + actualCategories);

        DB_Util.runQuery("select name from book_categories");
        List<String> expectedCategories = DB_Util.getColumnDataAsList(1);
        System.out.println("expectedCategories = " + expectedCategories);
        Assert.assertEquals(expectedCategories, actualCategories);


    }
}