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




