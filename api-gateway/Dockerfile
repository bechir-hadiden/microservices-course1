# ================= STAGE 1 : BUILD =================
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /workspace

# Copier le pom parent (nécessaire car projet multi-module)
COPY pom.xml .
COPY api-gateway/pom.xml api-gateway/pom.xml

# Télécharger les dépendances (mise en cache Docker)
RUN mvn -f api-gateway/pom.xml dependency:go-offline -B || true

# Copier le code source du module et builder
COPY api-gateway/src api-gateway/src
RUN mvn -f api-gateway/pom.xml clean package -DskipTests

# ================= STAGE 2 : RUNTIME =================
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

COPY --from=build /workspace/api-gateway/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
