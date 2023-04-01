Feature: Default

	#*US07:*
	#
	#As a student, I should be able to borrow a book
	#
	# 
	#
	#Scenario Outline: Student borrow new book 
	#  Given the "student" on the home page 
	#  And the user navigates to "Books" page 
	#  And the user searches book name called "Head First Java" 
	#             When the user clicks Borrow Book  Then verify that book is shown in "Borrowing Books” page 
	#  And verify logged student has same book in database
	@B28G19-151 @ui @db
	Scenario: US07_IK - Verify if a student is able to borrow a book
		Given the "student" on the home page IK
		    And the user navigates to "Books" page IK
		    And the user searches for "Clean Code" book IK
		    When the user clicks Borrow Book IK
		    Then verify that book is shown in "Borrowing Books" page IK
		    And  verify logged student has same book in database IK