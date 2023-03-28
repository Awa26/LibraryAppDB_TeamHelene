Feature: As a data consumer, I want UI and DB book categories are match.
  @ui @db @tk
  Scenario: verify book categories with DB
    Given the "librarian" on the home page TK
    When the user navigates to "Books" page TK
    And the user clicks book categories TK
    Then verify book categories must match book_categories table from db TK