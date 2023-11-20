# Use an official OpenJDK runtime as a base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Maven executable to the container image
COPY mvnw .
COPY .mvn .mvn

# Copy the project files
COPY pom.xml .
COPY src src

# Build the application
RUN chmod +x ./mvnw && ./mvnw clean package

# Expose the port that the app will run on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/wk-consult-1.0.0.jar"]
