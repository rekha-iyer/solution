# Getting Started

The application is a solution for a backend service meant to support a web application that allows a user to view transactions on any of the accounts they hold.


## Example usage

The application can be started using IDE tools or using command line.

```sh
java -jar solution-1.0.0.jar
```

## Getting Started

### Build & Test

The project can be built using :  `mvn clean package`.
The jar is created in `target` directory

## Sample Test Curl

Example curl command to test the endpoint.

`curl -i -X GET http://localhost:8080/user/1/accounts`

## API Documentation

Once the application is started, api documentation can be view at

`http://localhost:8080/swagger-ui.html`

## Design Choices 

* It is assumed that the data that is displayed is in a database.
    * For the purpose of this solution, the in-memory H2 database has been used and the data has been loaded using a data.sql file.
* It is assumed that the user logged in is valid and exists in the system.
* Exhaustive validation and tests have not been implemented. Representative test covering major flows has been implemented.
