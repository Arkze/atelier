FROM openjdk:21-ea-jdk-slim

WORKDIR /app

COPY gradlew .
COPY gradle ./gradle
COPY build.gradle settings.gradle ./
COPY src ./src

RUN chmod +x ./gradlew
RUN ./gradlew bootJar --no-daemon -x test 

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "build/libs/spring-boot-0.0.1-SNAPSHOT.jar"]