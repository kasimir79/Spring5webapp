FROM openjdk:17-jdk-slim
WORKDIR /app
COPY spring5webapp-1.0.jar app.jar
CMD ["java", "-jar", "app.jar"]
