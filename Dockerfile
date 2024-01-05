# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install -Dmaven.test.skip=true -DskipTests

# Stage 2: Run the application
FROM openjdk:17-alpine
WORKDIR /jpa
COPY --from=build /app/target/rest-api-0.0.1-SNAPSHOT.jar .abebetekle/springboot-aws.jar
EXPOSE 8080
CMD ["java", "-jar", "springboot-aws.jar"]