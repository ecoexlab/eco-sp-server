FROM openjdk:11 AS builder

COPY gradlew .

COPY gradle gradle

COPY build.gradle .

COPY settings.gradle .

COPY src src

RUN chmod +x ./gradlew

RUN ./gradlew bootJar

FROM openjdk:11
COPY --from=builder build/libs/*.jar eco-api-server.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/eco-api-server.jar"]