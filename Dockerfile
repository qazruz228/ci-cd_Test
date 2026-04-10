FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app
COPY pom.xml .

RUN mvn -B -f pom.xml dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

FROM amazoncorretto:17-alpine

WORKDIR /app

RUN addgroup -S spring && adduser -S spring -G spring

COPY --chown=spring:spring --from=build /app/target/*.jar app.jar

EXPOSE 8080

USER spring:spring

ENTRYPOINT ["java","-jar","app.jar"]

