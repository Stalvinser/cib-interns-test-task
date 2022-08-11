FROM openjdk:11
LABEL maintainer="Stalvinser"
#VOLUME /main-app
ADD target/socksEntity.api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app.jar"]