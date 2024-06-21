FROM openjdk:17-jdk-slim as runtime

WORKDIR /app

COPY target/vitals-service.jar vitals-service.jar

EXPOSE 9001

ENTRYPOINT ["java", "-jar", "vitals-service.jar"]
