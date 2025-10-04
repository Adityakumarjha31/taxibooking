# Stage 1: Build jar using Maven
FROM maven:3.9.0-eclipse-temurin-17 AS build

WORKDIR /app

# Copy source code
COPY pom.xml .
COPY src ./src

# Build jar (skip tests for faster build)
RUN mvn clean package -DskipTests

# Stage 2: Use lightweight Java runtime
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/taxibooking-0.0.1-SNAPSHOT.jar app.jar

# Expose port and run jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
