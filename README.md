# Project Title

Logger Tools


### Prerequisites

JDK 1.8 or later

Maven 3.2+

You can also import the code straight into your IDE:

Spring Tool Suite (STS)

IntelliJ IDEA

## Getting Started
First of all, run this database Script

```
CREATE DATABASE `logtracker` /*!40100 DEFAULT CHARACTER SET latin1 */;

CREATE TABLE `Log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(300) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(40) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `logtracker`.`person`
(
 `first_name`,
 `last_name`,
 `age`)
VALUES
(
 'Juan',
 'Perez',
 33);


```
* Download and unzip the source repository for this guide, or clone it using Git: git clone git@github.com:ferrensiv/demoLogger.git
* Modify the main/resources/aplication.properties file according to your database configuaration
* Import the project using your IDE and run the Spring Boot Application
* Alternatively you can run the application from command line
  ``` Navigate to the folder where you have unziper the source
      Open a terminal and run these commands:
      mvn clean;package
      mvn install
      java -jar target/demoLogger-0.0.1-SNAPSHOT.jar
      mvn spring-boot:run

    ```



### Usage

In order to see this application in action we provides a REST service where is used the log functionality
Open a browser and paste these endpoints:
http://localhost:8099/person?id=-1   ->should print a warning in console
http://localhost:8099/person?id=1   ->should not print anything

 

## Authors

* **Fernando Sivila** 



