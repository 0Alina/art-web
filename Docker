# 1. Build stage
FROM maven:3.9.7-sapmachine-22 AS build
WORKDIR /app

# Copiem doar pom.xml la început pentru a folosi cache-ul Docker
COPY pom.xml .
# Copiem sursa
COPY src ./src

# Buildăm fără teste
RUN mvn clean package -DskipTests

# 2. Run stage
FROM eclipse-temurin:22-jre
WORKDIR /app

# Mutăm jar-ul rezultat
COPY --from=build /app/target/*.jar app.jar

# Expunem portul (Thymeleaf implicit pe 8080)
EXPOSE 8080

# Comanda de start
ENTRYPOINT ["java", "-jar", "app.jar"]
