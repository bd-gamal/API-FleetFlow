FROM eclipse-temurin:21-jdk

WORKDIR /app

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} /app/greeting.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/greeting.jar"]
