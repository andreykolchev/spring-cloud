FROM java:8
VOLUME /tmp
ADD hystrix.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 7979
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]