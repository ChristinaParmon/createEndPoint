FROM adoptopenjdk:11-jre-hotspot
ADD target/spring-end-point.jar spring-end-point.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/spring-end-point.jar"]