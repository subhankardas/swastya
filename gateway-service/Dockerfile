FROM openjdk:17-jdk-slim as runtime

WORKDIR /app

COPY target/gateway-service.jar gateway-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "gateway-service.jar"]
