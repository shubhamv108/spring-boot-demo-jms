## Environment:
- Spring Boot version: 3.2.1

## Requirements:
JMS works by sending messages to a message destination, which are then taken by message receiver. Scheduling can be used to make certain code run at a specified time period. This project deals with sending and receiving messages at a scheduled time.

## Commands
- run: 
```bash
./gradlew clean build -DskipTests && java -jar build//libs/spring-boot-demo-jms-0.0.1.jar
```
- install: 
```bash
./gradlew clean build
```
- test: 
```bash
./gradlew clean test
```
