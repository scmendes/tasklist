# Silvio C Mendes - Tasklist

Small task list application. 
This simple application is able to manage the personal tasklist issues.
It offers Create, Read, Update and Delete operations over the task item. 

### Requirements

- Maven
- JDK 8
- My SQL (or H2 if you prefer a in memory database solution)

### Configuration

If you wanna change some default configuration it is super simple.
To do this just edit `application.properties` and choose the configuration that fits.

### Frameworks
- Spring boot
- Spring data JPA
- Spring boot data rest
- AngularJS

### Running

To build and start the server simply type from the root directory:
```sh
$ mvn spring-boot:run
```

From Eclipse plugins
```sh
$ Run >> maven clean package install
$ Run >> java application (from the Application.java)
```

From command line (from the target diretory)
```sh
$ java -jar task-list-silvio-0.1.0.jar;
```


### Using

Browse to `http://localhost:8080` to see the application in action.

The H2 database is in memory so rebooting should reset the data.


