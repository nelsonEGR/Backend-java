# Imagen base con JDK 17 (compatible con Spring Boot)
FROM eclipse-temurin:17-jdk

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar pom.xml y el wrapper de Maven
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Dar permisos de ejecución al wrapper
RUN chmod +x mvnw

# Descargar dependencias (esto ayuda a cachear y acelerar builds)
RUN ./mvnw dependency:go-offline

# Copiar el código fuente
COPY src ./src

# Compilar y empaquetar la aplicación (sin tests para más rápido)
RUN ./mvnw clean package -DskipTests

# Copiar el JAR generado
COPY target/*.jar app.jar

# Exponer el puerto (Render inyecta PORT, pero esto ayuda en local)
EXPOSE 8080

# Comando de inicio
CMD ["java", "-jar", "app.jar"]