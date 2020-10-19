# Step : Build with Maven Image
FROM maven:3-adoptopenjdk-11 as target

WORKDIR /build

COPY pom.xml .

# Install plugin to cache deps
RUN mvn dependency:go-offline

COPY src/ /build/src/

RUN mvn package -DskipTests

# Step : Run with JRE Image
FROM adoptopenjdk/openjdk11:jre-11.0.8_10-alpine

COPY --from=target /build/target/company-admin.jar /app/my-app.jar

CMD exec java $JAVA_OPTS -jar /app/my-app.jar