FROM openjdk:11-jdk-stretch
ADD target/workspace-service-0.0.1-SNAPSHOT.jar /src/main/workspace-service-0.0.1-SNAPSHOT.jar
WORKDIR /src/main
ENTRYPOINT ["java","-jar","workspace-service-0.0.1-SNAPSHOT.jar"]