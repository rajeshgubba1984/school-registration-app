FROM openjdk:11-jdk-alpine
COPY target/school-registration-service-0.0.1-SNAPSHOT.jar school-registration-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/school-registration-service-0.0.1-SNAPSHOT.jar"]