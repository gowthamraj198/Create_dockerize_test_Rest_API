FROM java:7
FROM maven
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY . /usr/src/app/
RUN mvn clean install
EXPOSE 9999
#RUN mvn clean package