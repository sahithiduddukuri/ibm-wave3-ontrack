FROM openjdk:11
ADD ./target/recommend-service-0.0.1-SNAPSHOT.jar /event/src/recommend-service-0.0.1-SNAPSHOT.jar
WORKDIR event/src
ENTRYPOINT ["java","-jar","recommend-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 8083