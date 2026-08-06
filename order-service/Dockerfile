FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
# On prend le JAR qui a été généré par Maven juste avant
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
