FROM eclipse-temurin:21-jdk
WORKDIR /app
# On copie directement le JAR depuis votre dossier target
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
