
Feature: As a data consumer, I want UI and DB book categories are match.
@ui @db @wip
  Scenario: verify book categories with DB AK
    Given the "librarian" on the home page AK
    When the user navigates to "Books" page AK
    And the user clicks book categories AK
    Then verify book categories must match book_categories table from db AK