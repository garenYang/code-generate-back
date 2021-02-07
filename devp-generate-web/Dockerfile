FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER kakusilong@163.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /devp-web

WORKDIR /devp-web

EXPOSE 8088

ADD ./target/devp-generate-web-1.0.0.jar ./

CMD java -Djava.security.egd=file:/dev/./urandom -jar devp-generate-web-1.0.0.jar
