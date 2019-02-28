FROM openjdk:11
ADD ./target/user-user-service-0.0.1-SNAPSHOT.jar /event/src/user-user-service-0.0.1-SNAPSHOT.jar
WORKDIR event/src
ENTRYPOINT ["java","-jar","user-user-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 8805