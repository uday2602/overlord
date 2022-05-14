# overlord

This project contains 2 modules
- overlord-client -> which has API and internal implementation of the overlord library
- overlord-client-service -> this is a sample service logging the metrics to overlord library
--- This module has a `telegraf.conf` file which reads the metrics aggregates them and sends to the influxDB
--- It has a `run.sh` which has the required commands to run the client-service and the telegraf plugin 
Note: External dependencies has to be installed seperately.
- influx.tmpl has the code to create the influxdb with the right buckets, retention policies, tasks and dashboards

Following is how the sampled data looks like

