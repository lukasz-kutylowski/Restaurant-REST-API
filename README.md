# **Restaurant-REST-API Application**

This application create order for given data: client and products ids, and create invoice for given order_id.

## Used technologies:
* Spring Boot
* REST API
* JPA
* MySQL
* IntelliJ

## Example Postman JSON testing

Add some products:
POST
/product
{
    "name" : "Tyskie",
    "price" : 5
}

Add some clients:
POST
/client
{
    "name" : "Jan",
    "surname" : "Kowalski",
    "nip" : "1234567890"
}

Add order (ids - products id):
POST
/order
{
    "ids" : [
      1, 2  
    ],
    "name" : "Jan",
    "surname" : "Kowalski",
    "nip" : "1234567890"
}

Generate invocie for given order id:
GET
/invoice/{order_id}