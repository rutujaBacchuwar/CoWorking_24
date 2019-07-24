FROM openjdk:11-jdk-stretch
ADD target/user-service-1.0-SNAPSHOT.jar /src/main/user-service-1.0-SNAPSHOT.jar
ADD ./assets/SpaceData.csv /src/main/assets/SpaceData.csv
ADD ./assets/UserData1.csv /src/main/assets/UserData1.csv
WORKDIR /src/main
ENTRYPOINT ["java","-jar","user-service-1.0-SNAPSHOT.jar"]
