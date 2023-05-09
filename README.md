# Naumen-test

## What´s this
Internship test project. Service predicts age based on a person´s name
## How does it work
Name-age correlation is downloaded from file. For names out of the file´s list a request to agify.io defines the age.
## Features
Service provides session statistics: the name with the oldest age (and age itself) and list of requested names and number of requests. Now the statistics is held in RAM. 
## TODO
Although it´s not defined by project requirements the next step is to implement DB to keep name-age correlation and statistics
## Stack
Java 17, Spring Boot, Maven, Thymeleaf, Lombok
