# profile-cloud-rest
Apsis:
=======
Coding Testing from Apsis AB, this is a RESTful webservice application to store/get the named counters details.

 - Implement Caching for storing the response from request, so next time it can get the response from cache to improve the performance.

Technologies Used:
==================

- Java 8
- Spring Boot
- STS as IDE
- GIT Bash for code commit
- GIT Hub as Code Repository

How to Build the code:
======================
```sh
mvn clean install
```

How to test the application:
============================

I have used postman tool to test the below services.

To list all the counters and corresponding values

http://localhost:8080/profile/counters

To create Counter

http://localhost:8080/profile/create

To get the Counter value for the specific Counter

http://localhost:8080/profile/{counterName}


To add the Counter value for the existing Counter

http://localhost:8080/profile/update

Exception Handling
==================

- Returned proper HTTP Status code for all the REST Methods.

What needs to be done to make this as a complete REST Service
=============================================================

Persistence Layer:
==================
Spring Data + Mongo DB.

Storage Technology:
==================
Mongo DB - Document-oriented NoSQL Database.
Supports
	- Indexing
	- Replication - for High availability
	- Load balancing - using Shards

Fault Tolerance:
================

Circuit Breaker pattern using Netflix Hystrix
	- using fall back method

Scalability:
===========



Authentication:
==============

- Basic HTTP Authentication with SSL
- OAuth 2.0
