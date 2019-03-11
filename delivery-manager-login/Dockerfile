FROM openjdk:11

ADD ./target/delivery-manager-login-0.0.1-SNAPSHOT.jar /event/src/delivery-manager-login-0.0.1-SNAPSHOT.jar
EXPOSE 8808
WORKDIR event/src
ENTRYPOINT ["java","-jar","delivery-manager-login-0.0.1-SNAPSHOT.jar"]