@us04_AC
Feature: As a data consumer, I want UI and DB book information are match.
  @ui @db
  Scenario: Verify book information with DB AC
    Given the "librarian" on the home page AC
    And the user navigates to "Books" page AC
    When the user searches for "Awa Book" book AC
    And  the user clicks edit book button AC
    Then book information must match the Database AC