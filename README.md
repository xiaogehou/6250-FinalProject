# Flight tickets website

This is a complete website integrated with easy front page, backend APIs supported by sample datas saved in Mysql database.


## Project Summary
My project is a website of searching and buying air tickets for customers, and managing flights for admin. For the data basics, I designed models for user side including User, Customer and Authority, models for flight side including Airliner, Airplane, Flight and Seat. Then I generated a number of data for flights, an admin user with authority of ROLE_ADMIN then saved in database. Two kinds of role of user and admin have separate accessible webpages to perform.

## Functionality Summary
The main functions in my project including user register, login, logout, searching flights, buy tickets, add passengers and assign seats. As for admin, its main function is managing flights with operation of create, retrieve, delete and update.

## Summary of Technologies
* Maven project with Spring mvc framework;<br>
* Hibernate and annotations for the design of pojos and initialization of beans;<br>
* HQL and SQL to manage data in database;<br>
* Input filter to avoid danger injection like sql key words and html tags;<br>
* Spring security handled authorization by defined urls for user and admin;<br>
* Bootstrap for part of pages;<br>

## Roles’ Tasks and Screen Shots
* Anonymous User (Before login):
1)	Search and view flight result list by entering origin, destination and departure date but cannot buy tickets;
