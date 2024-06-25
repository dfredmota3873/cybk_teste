FROM openjdk:17-jdk-alpine
RUN mkdir /app
WORKDIR /app
EXPOSE 8080
COPY target/*.jar /app/app.jar
CMD ["java","-jar","/app/app.jar"]