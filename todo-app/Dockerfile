FROM openjdk:21-jdk-alpine
COPY --form=build /app/target/todo-app-0.0.1-SNAPSHOT.jar /app/todo-app.jar
CMD java -jar /app/todo-app.jar --spring.profiles.active=prod