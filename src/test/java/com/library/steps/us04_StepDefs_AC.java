package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class us04_StepDefs_AC {

    LoginPage loginPage = new LoginPage();

    DashBoardPage dashBoardPage = new DashBoardPage();

    BookPage bookPage = new BookPage();
//expectedBookName
    String actualBookName;
    String actualAuthor;
    String actualIsbn;
    String actualYear;
    String actualDescription;


    @Given("the {string} on the home page AC")
    public void the_on_the_home_page_AC(String username) {
        loginPage.login(username);
    }
    @Given("the user navigates to {string} page AC")
    public void the_user_navigates_to_page_AC(String moduleName) {
       dashBoardPage.navigateModule(moduleName);
    }
    @When("the user searches for {string} book AC")
    public void the_user_searches_for_book_AC(String bookName) {
        this.actualBookName= bookName;
        System.out.println("actualBookName = " + actualBookName);
        // WebElement search = bookPage.search;

        BrowserUtil.waitForClickablility(bookPage.search, 3).sendKeys(bookName);

    }
    @When("the user clicks edit book button AC")
    public void the_user_clicks_edit_book_button_AC() {
     BrowserUtil.waitForClickablility(bookPage.editBook(actualBookName), 3).click();
    }
    @Then("book information must match the Database AC")
    public void book_information_must_match_the_database_AC() {
        
        //creating the ui variables and assigning them
        actualBookName = bookPage.bookName.getAttribute("value");
        actualIsbn = bookPage.isbn.getAttribute("value");
        actualAuthor = bookPage.author.getAttribute("value");
        actualYear = bookPage.year.getAttribute("value");
        actualDescription = bookPage.description.getAttribute("value");
        
        //retrieve the query
        String query = "select name, id, name, isbn, year, author,  description from books\n" +
                "where name = '"+actualBookName+"'";
        //run the query
        DB_Util.runQuery(query);
        Map<String, String> bookInfo = DB_Util.getRowMap(1);
        String expectedBookName = bookInfo.get("name");
        String expectedIsbnName = bookInfo.get("isbn");
        String expectedYearName = bookInfo.get("year");
        String expectedAuthorName = bookInfo.get("author");
        String expectedDescription = bookInfo.get("description");

        System.out.println("actualBookName = " + actualBookName);
        System.out.println("actualAuthor = " + actualAuthor);

        // comparing actual to actual
        Assert.assertEquals(expectedBookName,actualBookName);
        Assert.assertEquals(expectedIsbnName,actualIsbn);
        Assert.assertEquals(expectedYearName,actualYear);
        Assert.assertEquals(expectedAuthorName,actualAuthor);
        Assert.assertEquals(expectedDescription,actualDescription);

        // closing the database connection
        DB_Util.destroy();
        
        
        
        
        

    }

}
