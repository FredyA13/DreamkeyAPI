# Etapa de build
FROM gradle:8.7.0-jdk21 AS build
COPY --chown=gradle:gradle . /home/gradle/project
WORKDIR /home/gradle/project
RUN gradle build --no-daemon --stacktrace --warning-mode all

# Etapa final
FROM azul/zulu-openjdk:21-latest
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080
