FROM eclipse-temurin

WORKDIR /var/www/java

COPY src/ /var/www/java/



RUN javac HolaMundo.java

EXPOSE 3000

CMD ["java", "HolaMundo"]