FROM maven:3.9.6-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTest
FROM openjdk:21-jdk-slim
COPY --from=build /target/Employee-manager-backend-0.0.1-SNAPSHOT.jar Employee-manager-backend.jar
Expose 8080
ENTRYPOINT ["java","-jar","Employee-manager-backend.jar"]