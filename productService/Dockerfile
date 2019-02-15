FROM openjdk:11

ADD ./target/productService-0.0.1-SNAPSHOT.jar /event/src/productService-0.0.1-SNAPSHOT.jar
EXPOSE 8084
WORKDIR event/src
ENTRYPOINT ["java","-jar","productService-0.0.1-SNAPSHOT.jar"]