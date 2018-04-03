FROM openjdk:jre-alpine
ARG JAR_FILE
ENV ARTIFACT_NAME sensoric-sensor-service.jar
RUN mkdir -p /usr/local/applications
WORKDIR /usr/local/applications
COPY ${JAR_FILE} ${ARTIFACT_NAME}
EXPOSE 38888
ENTRYPOINT java $JAVA_OPTS -jar $ARTIFACT_NAME $@

