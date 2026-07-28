FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY inventory-service/target/inventory-service-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
