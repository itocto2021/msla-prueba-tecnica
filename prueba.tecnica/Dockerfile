# Usar una imagen base de Maven con Java 17 para construir la aplicación
FROM maven:3.8.4-openjdk-17-slim AS build

# Copiar los archivos fuente a la imagen
COPY src /home/app/src
COPY pom.xml /home/app

# Construir la aplicación
RUN mvn -f /home/app/pom.xml clean package

# Usar una imagen base de Java 17 para correr la aplicación
FROM openjdk:17-jdk-slim

# Copiar el archivo jar a la imagen
COPY --from=build /home/app/target/*.jar shipping.methods-0.0.1-SNAPSHOT

# Exponer el puerto que tu aplicación utiliza
EXPOSE 8082

# Comando para iniciar tu aplicación
ENTRYPOINT ["java","-jar","/prueba.tecnica-0.0.1-SNAPSHOT.jar"]