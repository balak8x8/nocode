# A Spring Boot 3 Lowcode/Nocode Sample Project
Sample app generated from https://start.spring.io/ with the below
* Spring Boot 3
* Java 17
* Maven
* Dependencies
  * Spring Web
  * Flyway
  * MySQL
  * JDBC
  
This project demonstrates the below
* __DozerBeanMapper__, For pojo to pojo or DTO to pojo coversion, use __DozerBeanMapper__. Current example covers only the name of the fields are same
* __@Loggable__, For function entry and exit logging, use __@LOGGABLE__. JCABI Aspects https://aspects.jcabi.com/annotation-loggable.html. Since the 
current implementation of JCABI does not log the target class name we are using the logThis = true in @Loggable(prepend = true, logThis = true)
* __lombok__, instead of generating all the getter and setter functions for any class we can use __lombok__. Lombok also supports all args constructor
no args constructor and much mode
* __JPARepository__, Application uses __JPARepository__ to access database. __JPARepository__ does not require us to read any sql in the class
* __JSONMerge__, Application uses __JSONMerge__ to do deep merge of nested objects

```
Before build & run
  Create USERSERVICE database in the local MySQL server using the below command if u dont have an existing database
  CREATE DATABASE USERSERVICE;
  Put the mysql password in the application.yml at src/main/resources/application.yml at spring.datasource.password
  ```

```
To build & run
  mvn clean install
  mvn spring-boot:run
  ```
  

```
Examples
DozerBeanMapper, src/main/java/com/nocode/entity/UserEntity.java 
Loggable, src/main/java/com/nocode/controller/UserController.java
lombok, src/main/java/com/nocode/entity/UserEntity.java 
JPARepository, src/main/java/com/nocode/repository/UserRepository.java
JSONMerge, src/test/java/com/nocode/util/pojo/Employee.java & src/main/java/com/nocode/util/MergeUtil.java 
Unit Test, src/test/java/com/nocode/util/MergeUtilTest.java
Integration Test, src/test/java/com/nocode/controller/UserControllerTest.java
  ```

```
Note
  Please dont include Javax.persistence package for Entity and it has to be jakarta.persistence. Otherwise application restart will throw an error that Entity is not a managed type

  ```
