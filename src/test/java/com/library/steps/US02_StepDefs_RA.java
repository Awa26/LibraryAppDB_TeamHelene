package com.library.steps;

import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US02_StepDefs_RA {


        LoginPage loginPage;
        DashBoardPage dashBoardPage;
        String actualBorrowedBooksNumber;

        @Given("the {string} on the home page RA")
        public void the_on_the_home_page_RA(String user) {
            loginPage=new LoginPage();
            loginPage.login(user);
            BrowserUtil.waitFor(2);

        }

        @When("the librarian gets borrowed books number RA")
        public void the_librarian_gets_borrowed_books_number_RA() {
            dashBoardPage=new DashBoardPage();

            actualBorrowedBooksNumber = dashBoardPage.borrowedBooksNumber.getText();
            System.out.println(actualBorrowedBooksNumber);

            System.out.println("dashBoardPage.getModuleCount(\"Borrowed Books\") = " + dashBoardPage.getModuleCount("Borrowed Books"));


        }
        @Then("borrowed books number information must match with DB RA")
        public void borrowed_books_number_information_must_match_with_db_RA() {

            String query="select count(*) from book_borrow where is_returned=0";

            DB_Util.runQuery(query);

            String expectedBorrowBooksNumber = DB_Util.getCellValue(1,1);
            System.out.println("expectedBorrowBooksNumber = " + expectedBorrowBooksNumber);

            Assert.assertEquals(expectedBorrowBooksNumber,actualBorrowedBooksNumber);

        }

    }


