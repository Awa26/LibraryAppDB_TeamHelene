@us06_MP
Feature: Books module
  As a librarian, I should be able to add new book into library

  @db @ui
  Scenario Outline: Verify added book is matching with DB
    Given the "librarian" on the home page_MP
    And the user navigates to "Books" page_MP
    When the librarian click to add book_MP
    And the librarian enter book name "<Book Name>"_MP
    When the librarian enter ISBN "<ISBN>"_MP
    And the librarian enter year "<Year>"_MP
    When the librarian enter author "<Author>"_MP
    And the librarian choose the book category "<Book Category>"_MP
    And the librarian click to save changes_MP
    Then verify "The book has been created." message is displayed_MP
    And verify "<Book Name>" information must match with DB_MP
    Examples:
      | Book Name             | ISBN     | Year | Author          | Book Category        |
      | Marko Petrovic - SR   | 10112000 | 2021 | Kathy Sierra M  | Action and Adventure |
      | Marko Petrovic - SR   | 11112001 | 2006 | Mitch Lacey M   | Short Story          |