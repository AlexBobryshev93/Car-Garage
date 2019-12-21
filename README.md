# Car Garage

## Tutorial
A learning project. Single page CRUD-app using RESTful API.

### Technologies used:
* Java 8
* JavaScript
* AngularJS
* Spring Framework (Core, Boot, MVC, Data)
* H2 database (embedded)
* Thymeleaf
* Maven

### Steps to setup

**1. Clone the repository (alternatively you can just download it) using 
the following command:**

```bash
git clone https://github.com/AlexBobryshev93/Car-Garage
```

**2. Run the application**

Use the following command from the root directory of the project to run it:

```bash
mvn spring-boot:run
```

Also you may do the same from your IDE.

**3. Use the application as you wish**

Now you can access the application at http://localhost:8080/ in your browser
(if you didn't configure another port for this purpose in 
`src/main/resources/application.properties` 
or in a configuration class for Spring).

The frontend of this application works calling the RESTful API in
`MainRestController` and binding the view with the model data
via AngularJS.

Enjoy!

