
@IG
Feature: As a data consumer, I want the user information are stored in mySql DB correctly in users table.
  Background:
    Given Establish the database connection
 @db
  Scenario: verify users has unique IDs IG
    When Execute query to get all IDs from users IG
    Then verify all users has unique ID IG

@db
  Scenario: verify users table columns IG
        When Execute query to get all columns IG
    Then verify the below columns are listed in result IG

      | id            |
      | full_name     |
      | email         |
      | password      |
      | user_group_id |
      | image         |
      | extra_data    |
      | status        |
      | is_admin      |
      | start_date    |
      | end_date      |
      | address       |
