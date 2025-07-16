# Imagen base confiable con JDK completo
FROM eclipse-temurin:17-jdk

# Instalar Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /app

# Copiar todo el proyecto
COPY . .

# Descargar dependencias y empaquetar
RUN mvn dependency:go-offline
RUN mvn package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/escape-room-app-1.0-SNAPSHOT.jar"]

