# spring-rest-boot
----------------------------------------------------------------------------------

Contents
1. Purpose
2. How to run unit and integration tests
3. How to deploy in a local environment

----------------------------------------------------------------------------------

Purpose :
This application can fetch US news headlines from a third party data provider,
with a REST GET endpoint

----------------------------------------------------------------------------------

How to run unit and integration tests :
Both unit and integration tests from this application can be run as JUNIT tests,
without the need to start tomcat as the tests use MockMVC 

----------------------------------------------------------------------------------

How to deploy in a local environment :
1. Download the project to a local directory
2. Import it into an IDE, as a Maven project
3. After ensuring all maven dependencies are configured without any errors during
import into the IDE, run the application as a - Spring Boot App. 
4. Or alternatively, this application can also br run from the command line using
tha Maven Spring Boot Plugin run goal. (Command to be executed - 
mvn spring-boot:run)
4. Once the application start up is clean, hit localhost:<portnumber>/us-headlines
end point, to see the headlines fetched as a response in JSON format
NOTE : 
1. Java 8, Maven, Spring Tool Suite, Apache Tomcat would be the pre-requisites
to run this application
2. Port number is configured in application.yml file and can be modified as
  needed 
  
----------------------------------------------------------------------------------
