# customer-vehicle-monitoring-poc
customer-vehicle-monitoring-poc

Code Challenge
            - Imagine you are one of our consultants and you got assigned to a project at one of our top partners.
## Scenario:       
            - They have a number of connected vehicles that belongs to a number of customers.
            - They have a need to be able to view the status of the connection among these vehicles on a monitoring display.
            - The vehicles send the status of the connection one time per minute.
            - The status can be compared with a ping (network trace); no request from the vehicle means no connection. 
            - So, vehicle is either Connected or Disconnected.
## Task:
            - Your task will be to create a data store that keeps these vehicles with their status and the customers who own them, as well as a GUI (preferably web-based) that displays the status.
            - Obviously, for this task, there are no real vehicles available that can respond to your "ping" request.
            - This can either be solved by using static values or by creating a separate machinery that returns random fake status.
## Requirements
            1. Web GUI (Single Page Application Framework/Platform).
                        - An overview of all vehicles should be visible on one page (full-screen display), together with their status.
                        - It should be able to filter, to only show vehicles for a specific customer.
                        - It should be able to filter, to only show vehicles that have a specific status.
            2. Random simulation to vehicles status sending.
            3. If database design will consume a lot of time, use data in-memory representation.
            4. Unit Testing.
            6. Complete analysis for the problem.
                        - Full architectural sketch to solution.
                        - Analysis behind the solution design, technologies....
                        - How to run your solution.
            7. Use CI (Travis, Circle, TeamCity...) to verify your code (Static analysis,..) and tests.
            8. Dockerize the whole solution using docker swarm or kubernates.
            9. Use Microservices architecture with Spring Cloud.
## Optional Requirements
            1. Write an integration test.
            2. Write an automation test.
            3. Explain if it is possible to be in Serverless architecture and how?
            4. Continuous delivery to the solution to the cloud.
##  Data:
Below you have all customers from the system; their addresses and the vehicles they own.
|-----------------------------------|

| Kalles Grustransporter AB         |

| Cementvägen 8, 111 11 Södertälje  |

|-----------------------------------|

| VIN (VehicleId)       Reg. nr.    |

|-----------------------------------|

| YS2R4X20005399401     ABC123      |

| VLUR4X20009093588     DEF456      |

| VLUR4X20009048066     GHI789      |

|-----------------------------------|
|-----------------------------------|

| Johans Bulk AB                    |

| Balkvägen 12, 222 22 Stockholm    |

|-----------------------------------|

| VIN (VehicleId)       Reg. nr.    |

|-----------------------------------|

| YS2R4X20005388011     JKL012      |

| YS2R4X20005387949     MNO345      |

------------------------------------|

|-----------------------------------|

| Haralds Värdetransporter AB       |

| Budgetvägen 1, 333 33 Uppsala     |

|-----------------------------------|

| VIN (VehicleId)       Reg. nr.    |

|-----------------------------------|

| VLUR4X20009048066     PQR678      |

| YS2R4X20005387055     STU901      |

|-----------------------------------|

## Solution:

# Technology Stack: Spring Boot RESTful API - API GateWay Eureka JPA Hibernate MySQL Example

# One to Many, Many to One bidirectional mapping
![image](https://user-images.githubusercontent.com/40293573/117363558-5c535200-aeda-11eb-84a9-0968a3143abf.png)






# RESTful API's
|METHOD	|PATH	                          |DESCRIPTION                                            |
|:----------|:------------------------------------|:------------------------------------------------------|
GET	|/api/customer	              |get all customers
POST	|/api/customer/customer	              |save customer
GET	|/api/customer/{customerid}	  |get customer by customerid
GET         |/api/vehicle                         |get all vehicles
POST	|/api/vehicle/vehicle/{customername}  |save vehicle with customername
GET	|/api/vehicle/vehicles{customername	  |get all vehicles with customer name
GET	|/api/vehicle/{vehicleid}	  |get vehicle by vehicleid
POST	|/api/vehicle/{vehicleid}	  |vehcile ping schedular will update the vehicle status

# MysQl Configuration and erureka serverregistration properties in application.properties file

- spring.application.name=online-vehicle-monitoring
- server.port=8081
- spring.datasource.url= jdbc:mysql://{YOUR_MSQL_SERVER}:3306/{DATABASE NAME}
- spring.datasource.username={MYSQL_USERNAME}
- spring.datasource.password={MYSQL_PASSWORD}
- spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
- spring.jpa.properties.hibernate.id.new_generator_mappings = false
- spring.jpa.properties.hibernate.format_sql = true
- #Hibernate ddl auto (create, create-drop, validate, update)
- spring.jpa.hibernate.ddl-auto=update
- logging.level.org.hibernate.SQL=DEBUG
- logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
- #register your servie in eureka server
- eureka.client.serviceUrl.defaultZone= http://{EUREKA_SERVER_HOST_NAME}:{EUREKA_SERVER_PORT}/eureka/






