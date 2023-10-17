FROM eclipse-temurin:17-jdk-alpine
ADD target/book-service.jar book-service.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "/book-service.jar"]