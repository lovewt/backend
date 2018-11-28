#!/bin/sh

#cd /data/tea-api/dev

export JAVA_HOME=/usr/local/java/jdk1.8.0_161
export PATH=$JAVA_HOME/bin:$PATH

java -jar -Xmx512m -Xms512m -Dloader.path=.,./lib dcmd-service-business-1.0.0-SNAPSHOT.jar --spring.profiles.active=$1  > ./logs/dcmd-service-business.log &
echo $! > dcmd-service-business.pid