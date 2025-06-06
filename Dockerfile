# Etapa 1: compilar con Gradle
FROM gradle:7.6.0-jdk21 AS build
COPY --chown=gradle:gradle . /home/gradle/project
WORKDIR /home/gradle/project
RUN gradle build --no-daemon

# Etapa 2: correr la app usando el JAR generado
FROM azul/zulu-openjdk:21-latest
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080
