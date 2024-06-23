**Architecture diagram**
![image](https://github.com/premChowdaryNim/product-service/assets/68907657/dbd375a0-b2f2-4369-b2e9-0dc9e95045ad)

**DFD**

![image](https://github.com/premChowdaryNim/product-service/assets/68907657/1bf493c1-4d4a-40c1-9f24-5b4561921055)

Mainly there are 4 services as below:
1.	Product Service: create and view products, acts as a product catalog.
2.	Order Service: can order products.
3.	Inventory Service: can check if product is in stock or not.
4.	Notification Service: Can send notifications, after order is placed.
   
Order service, Inventory Service and Notification Service are going to interact with each other in synchronous and Asynchronous communication. Each Service has their own database i.e., MongoDB.
Discovery Server: This is an application which holds the information about all client service applications. Every Micro service will register into the Eureka server and Eureka server knows all the client applications running on each port and IP address. Eureka Server is also known as Discovery Server.

![image](https://github.com/premChowdaryNim/product-service/assets/68907657/f5c4997e-53c8-49c8-9d13-aba218841c9d)

                                    Día: Discovery Server


**API Gateway**: Its acts like a gatekeeper which sends requests to different services ex. When user wants to communicate with services, they no need to provide any IP address, instead they will call API Gateway and from there the requests are redirected to respective services. Our applications also secured with this approach since at gateway level we are using authorization server called Keycloak. 
**Api Gateway Routing to Services as below:**
Inorder to Route to respective service after received a request from the user we need to add properties as below in API GATEWAY application.properties

![image](https://github.com/premChowdaryNim/product-service/assets/68907657/319d520b-72e3-4fc2-bd13-5f0973bc4d96)

Authentication and Authorization Using KEYCLOAK
Here we will add credentials in Keycloak and from services we have to connect to this server inorder to validate the requests. In application.properties we have to add as below.
spring.security.oauth2.resourceserver.jwt.issuer-uri= http://localhost:8080/realms/Springboot-microservices

![image](https://github.com/premChowdaryNim/product-service/assets/68907657/154999a5-da57-48aa-a5bf-0f761fc1cd04)

**API Authentication Process as below:**
1.	If any Unauthorized request came in, then we will get 401 Unauthorized response as below

![image](https://github.com/premChowdaryNim/product-service/assets/68907657/38a8b0f1-88f4-4787-86e4-4c891957d1a4)

2.	First we have to get access token by giving credentials
   
![image](https://github.com/premChowdaryNim/product-service/assets/68907657/0670a750-ea35-4c65-9be0-0903a3c350f4)

3.	Once provided credentials are authenticated we will receive Authentication complete as below
   
![image](https://github.com/premChowdaryNim/product-service/assets/68907657/3bf7d0ce-ada7-4769-af9d-8d8f04f54262)

4.	After Authorization we will receive token, then by using token we have to call certain API 

![image](https://github.com/premChowdaryNim/product-service/assets/68907657/8a68a480-2e02-4799-88ec-e0821185b6e9)

5.	Finally Product is created in Mongodb database, we received 201 created
   
![image](https://github.com/premChowdaryNim/product-service/assets/68907657/13855e6a-8b29-4d28-901c-c4d72948b82b)

**Docker containers**
We have used docker for running kafka broker ,zookeeper and also zipkin and keycloak servers

![image](https://github.com/premChowdaryNim/product-service/assets/68907657/f5d5bca7-ad11-4a2b-87ca-1fe001c668fe)

**Github Repository:**
https://github.com/premChowdaryNim?tab=repositories


**Request: ** http://localhost:57997/api/order 
  {
                    "orderLineItemsDtoList":[
                        
                        {
                        "skuCode":"oppo",
                        "price":999,
                        "quantity":3
                        }
                    ]
}
Client secret : oerayXpAhs9zUJkKDyZSF8GowKCjmJLr 
Client id : spring-cloud-client
Client Auth : send as basic auth header


**Inventory **
GET : http://localhost:58224/api/inventory?skuCode=Samsung_galaxy&skuCode=Iphone 14 pro max










