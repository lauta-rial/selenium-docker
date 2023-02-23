FROM openjdk:8u191-jre-alpine3.8

# install curl and jq
RUN apk add curl jq

#workspace
WORKDIR /tests/

# ADD .jar under target from host into this img.
# in case of any other dependency like csv, json, xls. Add it here. 
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs
ADD module_one.xml module_one.xml
ADD module_two.xml module_two.xml

# add healthcheck script
ADD healthcheck.sh healthcheck.sh
RUN dos2unix healthcheck.sh

# note that we are passing environment variables broser, hub_host, suite.xml (module)
ENTRYPOINT sh healthcheck.sh