package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class us06_StepDefs_MP {

    LoginPage loginPage = new LoginPage();
    BookPage bookPage = new BookPage();

    String actualName;


    @Given("the {string} on the home page_MP")
    public void the_on_the_home_page_MP(String librarian) {
        loginPage.login(librarian);
        BrowserUtil.waitFor(1);
    }



    @Given("the user navigates to {string} page_MP")
    public void the_user_navigates_to_page_MP(String Books) {
        bookPage.navigateModule(Books);
    }


    @When("the librarian click to add book_MP")
    public void the_librarian_click_to_add_book_MP() {
        bookPage.addBook.click();
    }


    @When("the librarian enter book name {string}_MP")
    public void the_librarian_enter_book_name_MP(String bookName) {
        bookPage.bookName.sendKeys(bookName);

        actualName = bookName;
    }


    @When("the librarian enter ISBN {string}_MP")
    public void the_librarian_enter_isbn_MP(String isbn) {
        bookPage.isbn.sendKeys(isbn);
    }


    @When("the librarian enter year {string}_MP")
    public void the_librarian_enter_year_MP(String year) {
        bookPage.year.sendKeys(year);
    }


    @When("the librarian enter author {string}_MP")
    public void the_librarian_enter_author_MP(String author) {
        bookPage.author.sendKeys(author);
    }


    @When("the librarian choose the book category {string}_MP")
    public void the_librarian_choose_the_book_category_MP(String category) {
        Select select = new Select(bookPage.categoryDropdown);
        select.selectByVisibleText(category);
    }


    @When("the librarian click to save changes_MP")
    public void the_librarian_click_to_save_changes_MP() {
        bookPage.saveChanges.click();
    }


    @Then("verify {string} message is displayed_MP")
    public void verify_message_is_displayed_MP(String expectedMessage) {
        String actualMessage = bookPage.toastMessage.getText();
        BrowserUtil.waitFor(1);


        Assert.assertEquals(expectedMessage, actualMessage);

    }


    @Then("verify {string} information must match with DB_MP")
    public void verify_information_must_match_with_db_MP(String book) {

        /*
        String query = "select distinct name from books\n" +
                "where name = '"+actualName+"'";


         */

        String query = "select distinct name from books\n" +
                "where name = '"+actualName+"'";
        DB_Util.runQuery(query);

        String expectedName = DB_Util.getFirstRowFirstColumn();
        System.out.println("actualName = " + actualName);
        System.out.println("expectedName = " + expectedName);

        Assert.assertEquals(expectedName,actualName);

    }


}
