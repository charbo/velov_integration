FROM hypriot/rpi-java
RUN update-ca-certificates -f 
RUN ["apt-get", "update"]
RUN ["apt-get", "install", "-y", "vim"]
VOLUME /tmp
EXPOSE 8080
ADD target/velov-integration-0.1-snapshot.jar /home/pi/app.jar
ENTRYPOINT ["java","-jar","/home/pi/app.jar"]
