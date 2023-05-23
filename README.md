# Flight tickets website

This is a complete website integrated with simple front page, backend APIs supported by sample datas saved in Mysql database.


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
### Anonymous User (Before login):
* Search and view flight result list by entering origin, destination and departure date but cannot buy tickets;<br>
<img src="https://github.com/xiaogehou/6250-FinalProject/blob/master/images/Picture1.png" width = 50% height = 50% /><br>
<img src="https://github.com/xiaogehou/6250-FinalProject/blob/master/images/Picture2.png" width = 50% height = 50% /><br>
    
### User Role (After login):
* Login by username and password;<br>
<img src="https://github.com/xiaogehou/6250-FinalProject/blob/master/images/Picture3.png" width = 30% height = 30% /><br>
    
* Search and view flight result list by entering origin, destination and departure date;<br>
* Choose specific flight to buy tickets (Can’t buy tickets before login);<br>
<img src="https://github.com/xiaogehou/6250-FinalProject/blob/master/images/Picture4.png" width = 50% height = 50% /><br>
    
* Add new passenger in user’s customer(passenger) list;<br>
<img src="https://github.com/xiaogehou/6250-FinalProject/blob/master/images/Picture5.png" width = 50% height = 50% /><br>
    
* Choose multiple passengers in customer list to buy tickets. When submit, the system will assign the cheapest seat of the flight to passengers. When above finished user can view passengers’ flight details including seat location and price.<br>
<img src="https://github.com/xiaogehou/6250-FinalProject/blob/master/images/Picture6.png" width = 50% height = 50% /><br>
    
* View history orders for all passengers that user created.<br>
<img src="https://github.com/xiaogehou/6250-FinalProject/blob/master/images/Picture7.png" width = 50% height = 50% /><br>
    
### Admin Role (After login)
* View all flights in database;<br>
* Search for wanted flights by origin and destination;<br>
<img src="https://github.com/xiaogehou/6250-FinalProject/blob/master/images/Picture8.png" width = 50% height = 50% /><br>
    
* Choose specific flight to update or delete;<br>
<img src="https://github.com/xiaogehou/6250-FinalProject/blob/master/images/Picture9.png" width = 50% height = 50% /><br>
    
* Create a new flight and save in database (Step 1: choose an airliner; Step 2: select an airplane belongs to chosen airliner then arrange flight details for it)<br>
<img src="https://github.com/xiaogehou/6250-FinalProject/blob/master/images/Picture10.png" width = 50% height = 50% /><br>
<img src="https://github.com/xiaogehou/6250-FinalProject/blob/master/images/Picture11.png" width = 30% height = 30% /><br>



