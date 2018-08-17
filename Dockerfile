FROM openjdk:jre-alpine

ARG JAR_FILE

ENV ARTIFACT_NAME sensoric-sensor-service.jar

RUN mkdir -p /usr/local/applications \
	&& apk add --update \
		bash \
	&& rm -rf /var/cache/apk/*

WORKDIR /usr/local/applications

COPY ${JAR_FILE} ${ARTIFACT_NAME}
COPY docker-entrypoint.sh /usr/local/bin

ENTRYPOINT ["docker-entrypoint.sh"]

EXPOSE 38889
