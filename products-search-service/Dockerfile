FROM openjdk:11
ADD ./target/product-search-service-0.0.1-SNAPSHOT.jar /event/src/product-search-service-0.0.1-SNAPSHOT.jar
WORKDIR event/src
ENTRYPOINT ["java","-jar","product-search-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 8998