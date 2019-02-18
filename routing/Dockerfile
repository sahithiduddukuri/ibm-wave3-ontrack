FROM openjdk:11

ADD ./target/delivery-manager-0.0.1-SNAPSHOT.jar /event/src/routing-0.0.1-SNAPSHOT.jar
EXPOSE 8900
WORKDIR event/src
ENTRYPOINT ["java","-jar","routing-0.0.1-SNAPSHOT.jar"]