FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ./build/libs/arrays-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]