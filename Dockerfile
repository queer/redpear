FROM maven:3

COPY . /app
WORKDIR /app
RUN mvn -B -q clean package

FROM openjdk:8-jre-slim
COPY --from=0 /app/target/RedPear*.jar /app/RedPear.jar

ENTRYPOINT ["/usr/bin/java", "-Xms128M", "-Xmx256M", "-jar", "/app/RedPear.jar"]