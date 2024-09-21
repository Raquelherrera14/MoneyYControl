#base image
FROM openjdk:17.0.2-jdk-oracle

#jar file path
ARG JAR_FILE=target/*.jar

#se le mete
COPY ${JAR_FILE} backend.jar

CMD apt-get update -y

#comando para correr java aplciation
ENTRYPOINT ["java","-Xmx2048M", "-jar", "/backend.jar"]