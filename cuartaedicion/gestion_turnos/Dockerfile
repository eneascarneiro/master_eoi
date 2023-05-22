# Maven build container
FROM maven:3.8.5-openjdk-18 AS maven_build

COPY pom.xml /gestionturnos/

COPY src /gestionturnos/src/

WORKDIR /gestionturnos/

RUN mvn package

#pull base image

FROM eclipse-temurin:18

#maintainer
MAINTAINER jmafernandez@hotmail.com
#expose port 8080
EXPOSE 9091

CMD java -jar /out/artifacts/gestturnos_jar/gestion-turnos-0.1.0.jar

#copy hello world to docker image from builder image

COPY --from=maven_build /tmp/target/gestion-turnos-0.1.0.jar /out/artifacts/gestturnos_jar/gestion-turnos-0.1.0.jar