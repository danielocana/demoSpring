FROM java:8
MAINTAINER me <danielparatodo@gmail.com>

EXPOSE 8000

ADD /build/libs /app

WORKDIR /app

CMD ["/usr/bin/java","-jar", "rancheros.jar"]