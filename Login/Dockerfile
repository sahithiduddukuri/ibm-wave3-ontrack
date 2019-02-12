FROM openjdk:11

ADD ./target/Login-0.0.1-SNAPSHOT.jar /event/src/Login-0.0.1-SNAPSHOT.jar
EXPOSE 7788
WORKDIR login/src
ENTRYPOINT ["java","-jar","Login-0.0.1-SNAPSHOT.jar"]
