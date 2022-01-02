FROM openjdk:11.0.13
EXPOSE 8080
ARG JAR_FILE=target/MANAGER-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
