FROM gradle:7.3.3-jdk11-alpine AS build

COPY --chown=gradle:gradle . /home/gradle/src
RUN apk update && apk add git
WORKDIR /home/gradle/src
RUN git init
RUN gradle build --no-daemon

# Run container

FROM openjdk:11-jre-slim AS runtime

WORKDIR /opt/avaire/

RUN adduser --disabled-password --gecos '' avaire; \
    chown avaire:avaire -R /opt/avaire; \
    chmod u+w /opt/avaire; \
    chmod 0755 -R /opt/avaire

USER avaire

COPY --from=build /home/gradle/src/AvaIre.jar /bin/
RUN java -jar /bin/AvaIre.jar -env --use-plugin-index
CMD ["java","-jar","/bin/AvaIre.jar","-env","--use-plugin-index"]
