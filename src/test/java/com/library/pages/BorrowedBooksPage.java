package com.library.pages;

import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import com.library.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BorrowedBooksPage extends BasePage {


    @FindBy(xpath = "//tbody//td[2]")
    public List<WebElement> allBorrowedBooksName;

    @FindBy(xpath = "//tr//a[not(contains(@class,'disabled'))]")
    public List<WebElement> allEligibleForReturn;

    public List<WebElement> findBookByName(String bookName){
        String path = "//td[.='" + bookName + "']/../td";
        return Driver.getDriver().findElements(By.xpath(path));
    }
    public void returnAllBooks() {
        LoginPage loginPage = new LoginPage();
        DashBoardPage dashBoardPage = new DashBoardPage();
        loginPage.login("student");
        String query = "select distinct u.email from (select * from book_borrow\n" +
                "where is_returned = 0) t\n" +
                "join users u on t.user_id = u.id;";
        DB_Util.runQuery(query);
        List<String> users = new ArrayList<>(DB_Util.getColumnDataAsList("email"));
        dashBoardPage.logOut();
        for(String each : users) {
            if(each.equals("student1@library") || each.equals("student1@library.com") || each.contains("librarian")) continue;
            //dashBoardPage.accountHolderName.click();
            loginPage.login(each, "student_password");

            dashBoardPage.navigateModule("Borrowing Books");


            if(allEligibleForReturn.size()==0) continue;
            else {
                for (WebElement eachBook : allEligibleForReturn){
                    eachBook.click();
                }
            }
           BrowserUtil.waitFor(15);
            dashBoardPage.logOut();

        }

    }
}