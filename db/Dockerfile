FROM mysql:5.7

MAINTAINER kakusilong@163.com)

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

COPY generate.sql /docker-entrypoint-initdb.d
