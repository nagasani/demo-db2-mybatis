# Demo DB2 MyBatis Spring Boot (Java 17)

This project shows how to call a DB2 stored procedure that returns:

* 2 IN parameters
* 2 OUT parameters
* 2 result sets

It uses Spring Boot 3.2, MyBatis 3.0, Java 17.

## Prerequisites

* Java 17+
* Maven 3.8+
* A local DB2 Developer-C running on `localhost:50000` with:
  * user: `db2inst1` / pass: `db2pwd`
  * database: `BLUDB`
  * procedure `DEMO.GET_CUSTOMERS_AND_ORDERS` as described in docs.

## Run

```bash
mvn clean spring-boot:run
```

Call the endpoint:

```
http://localhost:8080/data?minCustId=1&minOrdAmt=10.0
```
