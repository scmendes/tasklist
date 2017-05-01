# Silvio C Mendes - Tasklist

Small task list application. 
This simple application is able to manage the personal tasklist issues.
It offers Create, Read, Update and Delete operations over the task item. 

### Requirements

- Maven
- JDK 8
- My SQL (or H2 if you prefer a in memory database solution)

### Configuration

First you need to edit `application.properties` and choose the database option.

### Running

To build and start the server simply type

```sh
$ mvn spring-boot:run
```

from the root directory.

### Using

Browse to `localhost:8080` to see the application in action.

The H2 database is in memory so rebooting should reset the data.


