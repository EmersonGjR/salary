FROM openjdk:17
LABEL authors="Emerson"
#ADD ./salario-0.0.1-SNAPSHOT.jar salario-0.0.1-SNAPSHOT.jar
COPY ./salario-0.0.1-SNAPSHOT.jar salario-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "salario-0.0.1-SNAPSHOT.jar"]