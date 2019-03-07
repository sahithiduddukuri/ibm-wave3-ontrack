FROM openjdk:11

ADD ./target/container-manager-service-0.0.1-SNAPSHOT.jar /event/src/container-manager-service-0.0.1-SNAPSHOT.jar
EXPOSE 8011
WORKDIR event/src
ENTRYPOINT ["java","-jar","container-manager-service-0.0.1-SNAPSHOT.jar"]