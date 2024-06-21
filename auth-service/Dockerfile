FROM openjdk:17-jdk-slim as runtime

WORKDIR /app

COPY target/auth-service.jar auth-service.jar

EXPOSE 9000

ENTRYPOINT ["java", "-jar", "auth-service.jar"]
