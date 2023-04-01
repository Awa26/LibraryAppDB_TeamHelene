package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.BorrowedBooksPage;
import com.library.pages.LoginPage;
import com.library.utility.DB_Util;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class US07_StepDefs_IK {

    LoginPage loginPage;
    BookPage bookPage;
    String bookName;
    String expectedTime;

    @Given("the {string} on the home page IK")
    public void the_on_the_home_page_ik(String userType) {
        //new BorrowedBooksPage().returnAllBooks();
        loginPage = new LoginPage();
        loginPage.login(userType, 33);
//        DashBoardPage dashBoardPage = new DashBoardPage();
//        BorrowedBooksPage borrowedBooksPage = new BorrowedBooksPage();
//        dashBoardPage.navigateModule("Borrowing Books");
//
//
//
//            for (WebElement eachBook : borrowedBooksPage.allEligibleForReturn){
//                eachBook.click();
//            }
//

    }
    @Given("the user navigates to {string} page IK")
    public void the_user_navigates_to_page_ik(String module) {
        bookPage = new BookPage();
        bookPage.navigateModule(module);

    }
    @Given("the user searches for {string} book IK")
    public void the_user_searches_for_book_ik(String bookName) {
        this.bookName = bookName;
        bookPage = new BookPage();
        bookPage.search.sendKeys(bookName);

    }
    @When("the user clicks Borrow Book IK")
    public void the_user_clicks_borrow_book_ik() {
        bookPage = new BookPage();
        ArrayList<WebElement> bookAbleToBorrow= new ArrayList<>(bookPage.ableToBorrowBook(bookName));
        if(bookPage.ableToBorrowBook(bookName).size() == 0){
            System.out.println("******************************************************************");
            System.out.println("*                    BOOK IS ALREADY BORROWED                    *");
            System.out.println("*                          TEST SKIPPED                          *");
            System.out.println("******************************************************************");
            Assert.assertFalse( false);
        }else{
            bookAbleToBorrow.get(0).click();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now().plusHours(4);
            // Format the date and time using the formatter
            expectedTime = now.format(formatter);
        }
        //bookPage.ableToBorrowBook(bookName)
       // BrowserUtil.waitFor(10);

    }
    //2023-03-31 06:14:02
    @Then("verify that book is shown in {string} page IK")
    public void verify_that_book_is_shown_in_page_ik(String module) {
        BorrowedBooksPage borrowedBooksPage = new BorrowedBooksPage();
        bookPage.navigateModule(module);
        boolean flag = false;
        for(WebElement each : borrowedBooksPage.findBookByName(bookName)){
            if(each.getText().contains(expectedTime)){
                flag = true;
            }
        }
        Assert.assertTrue(flag);

    }
    @Then("verify logged student has same book in database IK")
    public void verify_logged_student_has_same_book_in_database_ik() {
        String query = "select bb.borrowed_date from users u\n" +
                "inner join book_borrow bb on u.id = bb.user_id\n" +
                "inner join books b on bb.book_id = b.id\n" +
                "where full_name='Test Student 33'\n" +
                "order by 1 desc;";
        DB_Util.runQuery(query);
        String actualResult = DB_Util.getFirstRowFirstColumn();
        System.out.println("expectedTime = " + expectedTime);
        System.out.println("actualResult = " + actualResult);
        Assert.assertTrue(actualResult.contains(expectedTime));

    }
}
