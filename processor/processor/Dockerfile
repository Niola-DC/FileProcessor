FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
WORKDIR /src
COPY target/fileUpload-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
EXPOSE 8080



#FROM ubuntu:latest
#LABEL authors="Donna"
#
#ENTRYPOINT ["top", "-b"]

