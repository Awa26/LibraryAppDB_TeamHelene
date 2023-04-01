@skip
Feature: Return all rented books
  @db @ui
  Scenario: Return the borrowed book from all student accounts
    When log in into all the students accounts that have borrowed books and return them