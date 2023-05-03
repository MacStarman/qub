FROM maven:3.5-jdk-8 AS build  

COPY . .
RUN mvn clean package

FROM openjdk:8-jre-alpine
COPY --from=build target/descriptions-0.0.1.jar /descriptions-0.0.1.jar
CMD java -jar /descriptions-0.0.1.jar