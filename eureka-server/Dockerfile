FROM maven:3.8.4-openjdk-17 AS builder
WORKDIR /projet
COPY ./src ./src
COPY ./pom.xml .
RUN mvn clean package
FROM openjdk:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} serveur.jar
ENTRYPOINT ["java","-jar","/serveur.jar"]

