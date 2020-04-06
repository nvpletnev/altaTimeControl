FROM openjdk:10-oracle
COPY /target/timecontrol.jar /
EXPOSE 8080
ENTRYPOINT ["java","-jar","/timecontrol.jar"]