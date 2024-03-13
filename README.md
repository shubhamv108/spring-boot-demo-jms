## Environment:
- Java version: 17
- Maven version: 3.*
- Spring Boot version: 3.0.6

## Read-Only Files:
- src/test/*

## Requirements:
JMS works by sending messages to a message destination, which are then taken by message receiver. Scheduling can be used to make certain code run at a specified time period. This project deals with sending and receiving messages at a scheduled time. 
The skeleton classes for sending and receiving messages are already in the project.
 
You must complete the project in the following way:

* Enable scheduling in the application.
* Enable JMS messaging in the application.

`ScheduledMessageSender.java`:
* Modify the `sendingInfoMessage` method and make it send the message `info` to the address `info@example.com` every 5 seconds. 

For example:
```
message = MessageObject("info","info@example.com")
should be sent every 5 seconds
```
* Modify the `sendingTestMessage` method and make it to send the message `test` to the address `test@example.com` every 8 seconds.

For example:
```
message = MessageObject("test","test@example.com")
should be sent every 8 seconds
```

`ScheduledMessageReceiver.java`:
- Modify the `receiveMessage` method to allow it to receive JMS messages.
- If a message is sent to the address `test@example.com`, throw an `Exception`. (An exception handler has already been provided.)
- If a message is sent to the address `info@example.com`, dump it to the console.

Your task is to complete the given project as per the above requirements so that it passes all the test cases when running the provided unit tests.

## Commands
- run: 
```bash
mvn clean package -DskipTests && java -jar target/SchedulingApi-1.0.jar
```
- install: 
```bash
mvn clean install
```
- test: 
```bash
mvn clean test
```
