FROM eclipse-temurin

WORKDIR  /opt/app

COPY src/ .

RUN javac Main.java

EXPOSE 3000

CMD ["java", "Main"]