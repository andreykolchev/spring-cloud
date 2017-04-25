FROM java:8
VOLUME /tmp
ADD rest-microservice.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 9090
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]