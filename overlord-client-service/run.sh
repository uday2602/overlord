#!/bin/sh

cd ../overlord-client || exit
mvn clean package install

cd ../overlord-client-service || exit
mkdir -p /tmp/overlord-client-service/logs
mkdir -p /tmp/overlord-client-service/read_logs
touch /tmp/overlord-client-service/aggregator-out.log
telegraf --config telegraf.conf &
mvn clean compile exec:java
