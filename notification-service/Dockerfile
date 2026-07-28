FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .
COPY notification-service/pom.xml notification-service/pom.xml

RUN mvn -f notification-service/pom.xml dependency:go-offline -B

COPY notification-service/src notification-service/src

RUN mvn -f notification-service/pom.xml clean package -DskipTests -B


FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=build /app/notification-service/target/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
