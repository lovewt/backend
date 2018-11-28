#!/bin/sh
PID=$(cat /root/dcmd/data/dcmd-service-business.pid)
kill -9 $PID