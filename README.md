## Environment:
- Spring Boot version: 3.2.1

## Requirements:
JMS works by sending messages to a message destination, which are then taken by message receiver. Scheduling can be used to make certain code run at a specified time period. This project deals with sending and receiving messages at a scheduled time.

Your task is to complete the given project as per the above requirements so that it passes all the test cases when running the provided unit tests.

## Commands
- run: 
```bash
./gradlew clean build -DskipTests && java -jar target/SchedulingApi-1.0.jar
```
- install: 
```bash
./gradlew clean build
```
- test: 
```bash
./gradlew clean test
```
