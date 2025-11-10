# Build stage (use Java 17 to match pom.xml)
FROM maven:3.8-openjdk-17 as builder

WORKDIR /app
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Runtime stage (Java 17 slim)
FROM openjdk:17-jdk-slim

WORKDIR /app
# Copy the fat jar produced by the spring-boot-maven-plugin
COPY --from=builder /app/target/*.jar app.jar

# Note: config.json is intentionally NOT copied at build time.
# Provide configuration at runtime (volume, ConfigMap, or env vars).

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
