FROM openjdk:11

ADD ./target/login-0.0.1-SNAPSHOT.jar /usr/src/login-0.0.1-SNAPSHOT.jar
EXPOSE 8090
WORKDIR usr/src
ENTRYPOINT ["java","-jar","login-0.0.1-SNAPSHOT.jar"]
