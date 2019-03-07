FROM openjdk:11

ADD ./target/routing-manager-0.0.1-SNAPSHOT.jar /event/src/routing-manager-0.0.1-SNAPSHOT.jar
EXPOSE 8010
WORKDIR event/src
ENTRYPOINT ["java","-jar","routing-manager-0.0.1-SNAPSHOT.jar"]
