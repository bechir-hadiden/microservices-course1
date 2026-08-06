FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
# On copie le JAR que vous avez compilé avec succès tout à l'heure
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
