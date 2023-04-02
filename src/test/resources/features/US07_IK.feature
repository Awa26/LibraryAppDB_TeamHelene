@B28G19-151 @ui @db @ik
Feature: Default

	Scenario: US07_IK - Verify if a student is able to borrow a book
		Given the "student" on the home page IK
		    And the user navigates to "Books" page IK
		    And the user searches for "Clean Code" book IK
		    When the user clicks Borrow Book IK
		    Then verify that book is shown in "Borrowing Books" page IK
		    And  verify logged student has same book in database IK

