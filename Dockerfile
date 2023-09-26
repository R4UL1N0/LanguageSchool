FROM openjdk:17-jdk

WORKDIR /app

COPY target/LanguageSchool-0.0.1-SNAPSHOT.jar /app/LanguageSchool-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "LanguageSchool-0.0.1-SNAPSHOT.jar"]