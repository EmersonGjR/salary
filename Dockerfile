FROM openjdk:20
LABEL authors="Emerson"
#ADD ./salario-0.0.1-SNAPSHOT.jar salario-0.0.1-SNAPSHOT.jar
COPY target/salario-0.0.1-SNAPSHOT.jar salario-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "salario-0.0.1-SNAPSHOT.jar"]