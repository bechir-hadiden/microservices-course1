# ================= STAGE 1 : BUILD =================
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY patient-service/pom.xml patient-service/pom.xml
RUN mvn -f patient-service/pom.xml dependency:go-offline -B
COPY patient-service/src patient-service/src
RUN mvn -f patient-service/pom.xml clean package -DskipTests -B

# ================= STAGE 2 : RUNTIME =================
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/patient-service/target/patient-service-*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
