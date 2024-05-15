# Sharath-Venkat-Narayana---NHSBSA
NHSBSA Test Exercise: NHS Search Functionality Job Search
Table of Contents
1. About the Project
2. Writing a test
3. Tools used
4. How to run the tests

About the Project
Automation Testing Using Java
selenium-cucumber is a behavior driven development (BDD) approach to write automation test script to test Web. It enables you to write and execute automated acceptance/unit tests. It is cross-platform, open source and free. Automate your test cases with minimal coding. 
Writing a test
The cucumber features goes in the features library and should have the ".feature" extension.
You can start out by looking at features/JobSearchSortedResults.feature. You can extend this feature or make your own features and glue them to the step definitions glue code.
Tools used
selenium-java 4.11.0
junit 4.12
cucumber-java 7.16.1
webdrivermanager 5.8.0

Running the test
Go to your project directory from terminal and hit following commands
•	mvn test (defualt will run on chrome and firefox browsers)
•	mvn test “-Dcucumber.options=“--tags @chrome” (to use only Chrome browser)
•	mvn test “-Dcucumber.options=“--tags @firefox” (to use only Firefox browser)

Cucumber reports are generated in HTML format under the Reports folder.

