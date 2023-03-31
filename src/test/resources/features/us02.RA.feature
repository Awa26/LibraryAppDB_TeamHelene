@US02_RA
Feature: As a librarian, I want to know borrowed books number
@ui@db
  Scenario: verify the total amount of borrowed books RA
    Given the "librarian" on the home page RA
    When the librarian gets borrowed books number RA
    Then borrowed books number information must match with DB RA