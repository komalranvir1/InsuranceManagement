#Insurence Management-ProjectName

In this Project I have Developed Api's For Client, CLaim And insurence Policy And Two More Api I Have Added For Associating policy
should be associated with a client and for claim should be associated withan insurance policy.



## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit 
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* [H2](https://www.h2database.com/) - Open-Source Relational Database Management System
* [git](https://git-scm.com/) - Free and Open-Source distributed version control system 
* [Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)


## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.insurence.management` class from your IDE.

- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing pom.xml
- Open Eclipse 
   - File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
   - Select the project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run as Java Application

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
or 
#create exicutable jar file 
mvn clean package

#run java jar file 
java -jar InsuranceManagement-2.4.4.jar



## packages

- `models` — to hold our Enum;
- `repositories` — to communicate with the database;
- `services` — to hold our business logic;
- `controllers` — to listen to the client;

- `resources/` - Contains all the static resources, templates and property files.
- `resources/application.properties` - It contains application-wide properties. Spring reads the properties defined in this file to configure your application. You can define server’s default port, server’s context path, database URLs etc, in this file.

- `test/` - contains unit and integration tests

- `pom.xml` - contains all the project dependencies


## A Brief Discription About Project

In this Project I have Developed Restful Api's for clients Insurence Policy and Claims ,
 Client :
                   GET            api/clients: Fetch all clients.
                   GET            api/clients/{id}: Fetch a specific client by ID.
                   POST           api/clients: Create a new client.
                   PUT            api/clients/{id}: Update a client's information.
                   DELETE         api/clients/delete/{id}: Delete a client.

Insurance Policies:
                   GET             api/policies: Fetch all insurance policies.
                   GET             api/policies/{id}: Fetch a specific insurance policy by ID.
                   POST            api/policies: Create a new insurance policy.
                   PUT             api/policies/{id}: Update an insurance policy.
                   DELETE          api/policies/delete/{id}: Delete an insurance policy. 
                   PUT             api/policies/{policy_id}/client/{client_id}: Associate Claim to policy ID
 Claims:           
                   GET             api/claims: Fetch all claims. 
                   GET             api/claims/{id}: Fetch a specific claim by ID.
                   POST            api/claims: Create a new claim.
                   PUT             api/claims/{id}: Update a claim's information.
                   DELETE          api/claims/delete/{id}: Delete a claim.
                   PUT             api/claims/{policy_id}/claim/{claim_id}: Associate Claim to policy ID


## Structure:
The project (a.k.a. project directory) has a particular directory structure. A representative project is shown below:


.
├── Spring Elements
├── src
│   └── main
│       └── java
│           ├── com.insurence.management 
│           ├── com.insurence.management.controller 
│           ├── com.insurence.management.entities 
│           ├── com.insurence.management.enums 
│           ├── com.insurence.management.model
│           ├── com.insurence.management.repo
│           ├── com.insurence.management.service
│           ├── com.insurence.management.serviceImpl
│           
│           
├── src
│   └── main
│       └── resources
│           ├── application.properties
│        
├── src
│   └── test
│       └── java
├── JRE System Library
├── Maven Dependencies  
├── target
│   └── generated-sources
│       └── annotations 
├── target
│   └── generated-test-sources
│       └── annotations 
├── src
├── target
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
└── temp.txt
```

