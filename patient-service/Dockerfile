

# ================= STAGE 1 : BUILD =================
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml .
COPY product-service/pom.xml product-service/pom.xml
RUN mvn -f product-service/pom.xml dependency:go-offline -B

COPY product-service/src product-service/src
RUN mvn -f product-service/pom.xml clean package -DskipTests -B

# ================= STAGE 2 : RUNTIME =================
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

COPY --from=build /app/product-service/target/product-service-*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
