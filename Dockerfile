FROM openjdk:17.0.2-jdk-slim-buster
COPY build/libs/flat-service.jar flat-service.jar
ENTRYPOINT ["java", "-jar", "flat-service.jar"]