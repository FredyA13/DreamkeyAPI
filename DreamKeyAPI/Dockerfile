FROM azul/zulu-openjdk:17-latest
VOLUME /tmp
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/DreamKeyAPI-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
