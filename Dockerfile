FROM openjdk:8-jdk-alpine
ADD target/*.jar app.jar
EXPOSE 9080
CMD ["java","-jar","/app.jar"]