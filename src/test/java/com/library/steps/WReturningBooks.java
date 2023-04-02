package com.library.steps;

import com.library.pages.BorrowedBooksPage;
import io.cucumber.java.en.When;

public class WReturningBooks {

    @When("log in into all the students accounts that have borrowed books and return them")
    public void log_in_into_all_the_students_accounts_that_have_borrowed_books_and_return_them() {
        new BorrowedBooksPage().returnAllBooks();
    }
}
