FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN

FROM alpine:3.10

RUN apk --no-cache add openjdk11 --repository=http://dl-cdn.alpinelinux.org/alpine/edge/community
RUN apk add bash vim curl wget jq docker git tar unzip bash-completion ca-certificates
RUN cd /opt && curl -sSl http://mirror.vorboss.net/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz | tar -xz

ENV PATH "$PATH:/opt/apache-maven-3.6.3/bin"
ENV DB_ADDRESS host.docker.internal
ENV MQTT_ADDRESS host.docker.internal
# ENV INFLUXDB_ADDRESS host.docker.internal
ENV PORT 8080

COPY . /aord-backend

EXPOSE $PORT

WORKDIR /aord-backend

CMD mvn spring-boot:run