FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml .
COPY order-service/pom.xml order-service/pom.xml
RUN mvn -f order-service/pom.xml dependency:go-offline -B

COPY order-service/src order-service/src
RUN mvn -f order-service/pom.xml clean package -DskipTests -B

FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/order-service/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
