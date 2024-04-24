#start with a base image containing java runtime
FROM openjdk:17-jdk-slim

#Information about who maintain the image
MAINTAINER cristi.com

#Add the application jar to the image
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

#Execute the application same as I would to from cmd line: "java -jar target/accounts-0.0.1-SNAPSHOT.jar"
ENTRYPOINT ["java","-jar", "accounts-0.0.1-SNAPSHOT.jar"]