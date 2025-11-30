# Etapa 1: Build con Maven
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

# Copiar pom.xml y dependencias
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

# Copiar código fuente y compilar
COPY src ./src
RUN ./mvnw clean package -DskipTests

# Etapa 2: Imagen final solo con el JAR
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copiar el JAR desde la etapa de build
COPY --from=build /app/target/*.jar app.jar

# Exponer puerto (Render inyecta PORT automáticamente)
EXPOSE 8080

# Comando de inicio
CMD ["java", "-jar", "app.jar"]