FROM openjdk:17-jdk-slim AS base

ENV APP_HOME=/app

RUN mkdir $APP_HOME

WORKDIR $APP_HOME

COPY target/be-1.0.0.jar $APP_HOME/app.jar
COPY src/main/resources/application.properties /config/application.properties

ENV SPRING_CONFIG_LOCATION=/config/
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]