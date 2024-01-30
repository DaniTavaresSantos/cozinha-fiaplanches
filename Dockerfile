FROM maven:latest

ENV SPRING_KAFKA_BOOTSTRAP_SERVERS=kafka1:19091
ENV REST_ORDER_ENDPOINT=http://fiap-lanches-client-api:8081/v1/order
WORKDIR /app
RUN rm -rf /app/*
COPY . /app
RUN mvn clean install -DskipTests
RUN mkdir jar
RUN mv /app/target/administrador-fiaplanches-0.0.1-SNAPSHOT.jar /app/jar/fiap-lanches-admin-app.jar
EXPOSE 8086

ENTRYPOINT ["java", "-jar", "/app/jar/fiap-lanches-admin-app.jar"]
