FROM openjdk:13-jdk-alpine

RUN addgroup -S spring && \
    adduser -S spring -G spring && \
    apk --no-cache add shadow && \
    usermod -u 1000 spring && \
    groupmod -g 1000 spring

USER spring:1000

ENV WORKING_DIR=/app

WORKDIR ${WORKING_DIR}
