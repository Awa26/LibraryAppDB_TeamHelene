package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.LoginPage;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class us05_stepDefs_BW {

    LoginPage loginPage = new LoginPage();
    BookPage bookPage = new BookPage();

    @Given("Establish the database connection BW")
    public void establish_the_database_connection_bw() {

        System.out.println("hooks runs this");
    }
    @When("I execute query to find most popular book genre BW")
    public void i_execute_query_to_find_most_popular_book_genre_bw() {


        DB_Util.runQuery("select bc.name,count(*) from book_borrow bb\n" +
                "inner join books b on bb.book_id = b.id\n" +
                "inner join book_categories bc on b.book_category_id=bc.id\n" +
                "group by name order by 2 desc");
    }
    @Then("verify {string} is the most popular book genre BW")
    public void verify_is_the_most_popular_book_genre_bw(String Fantasy) {


        String expectedBG = DB_Util.getFirstRowFirstColumn();
        System.out.println(DB_Util.getFirstRowFirstColumn());
        Assert.assertEquals(expectedBG,Fantasy);
    }

}
