FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_FILE=target/company-admin.jar

WORKDIR /app

COPY ${JAR_FILE} app.jar

CMD ["java","-jar","app.jar"]