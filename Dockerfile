FROM amazoncorretto:17-alpine-jdk
COPY target/service-cache-0.0.1-SNAPSHOT.jar service-cache-0.0.1-SNAPSHOT.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/service-cache-0.0.1-SNAPSHOT.jar"]