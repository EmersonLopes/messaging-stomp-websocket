FROM maven:3.8.4-openjdk-11 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11
WORKDIR /app
COPY --from=build ./app/target/*.jar ./app.jar

ENTRYPOINT java -jar app.jar