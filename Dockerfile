FROM openjdk:21-ea-17-jdk-slim-bullseye

COPY target/github-anomily-detector-*-spring-boot.jar github-anomaly-detector.jar
CMD ["java", "--enable-preview", "-jar", "github-anomaly-detector.jar"]