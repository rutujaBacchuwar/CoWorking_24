FROM openjdk:11-jdk-stretch
ADD target/booking-service-0.0.1-SNAPSHOT.jar /src/main/booking-service-0.0.1-SNAPSHOT.jar
WORKDIR /src/main
ENTRYPOINT ["java","-jar","booking-service-0.0.1-SNAPSHOT.jar"]

