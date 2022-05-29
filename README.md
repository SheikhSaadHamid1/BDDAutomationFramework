# JAVA BDD Framework
Java BDD Framework to automate Web and API Tests using Java, Selenium RestAssured and Cucumber

Environment Prerequisites
Before starting the execution of script, please ensure, that environment is configured with 
•	Java 
•	Maven. 

Java JDK path should be configured in Environment variables.
For this project, Java version 1.8 and Maven version 3.8.1 is used.


Getting Code from GitHub

Clone project from following URL
https://github.com/SheikhSaadHamid1/BDDAutomationFramework.git


Executing Scripts from Command Line

Running API and Web Scripts

Type following commands in command line

•	mvn clean
•	mvn compile
•	mvn test
Or write a single command to compile and run both API and Web tests
•	mvn compile verify



Running API Only Scripts

Type following command in command line to run API Only tests
•	mvn clean
•	mvn compile
•	mvn test -Dcucumber.filter.tags="@APITest"

Running Web Only Scripts

Type following command in command line to run Web Only tests
•	mvn clean
•	mvn compile
•	mvn test -Dcucumber.filter.tags="@WebTest"

Note: Data Parameters for Web Tests and Authentication Credentials for API Tests might needs to be updated to run successful tests. 



