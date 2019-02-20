FROM openjdk:11
ADD ./target/registration-service-0.0.1-SNAPSHOT.jar /event/src/registration-service-0.0.1-SNAPSHOT.jar
WORKDIR event/src
ENTRYPOINT ["java","-jar","registration-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 8805