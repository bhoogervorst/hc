FROM openjdk:17
ADD target/spring-boot-hc.jar spring-boot-hc.jar
EXPOSE 8080

# Environment variables for the PostgreSQL connection (placeholders)
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/postgres
ENV SPRING_DATASOURCE_USERNAME=postgres
ENV SPRING_DATASOURCE_PASSWORD=changeme

# Define the entry point to wait for the database and then start the Spring Boot application
ENTRYPOINT ["java", "-jar", "spring-boot-hc.jar"]