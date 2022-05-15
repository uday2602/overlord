# overlord

This project contains 3 modules
- overlord-client -> which has API and internal implementation of the overlord library
- overlord-client-service -> this is a sample service logging the metrics to overlord library<br>
--- This module has a `telegraf.conf` file which reads the metrics aggregates them and sends to the influxDB<br>
--- It has a `run.sh` which has the required commands to run the client-service and the telegraf plugin<br>
<b>Note: External dependencies has to be installed seperately.</b><br>
- influx.tmpl has the code to create the influxdb with the right buckets, retention policies, tasks and dashboards<br>
--- there are multiple buckets for different metrics aggregation window. i.e. one for raw_logs, 1min, 5min, etc<br>
--- tasks has downsampled tasks which read from raw logs and downsample to appropriate buckets<br>

Following is how the sampled data looks like

<tr>
<td>Raw metrics</td>
<td><img width="559" alt="Screenshot 2022-05-15 at 1 03 29 AM" src="https://user-images.githubusercontent.com/887164/168445921-ee4a8cba-811b-4874-9270-b2f68d0c5351.png"></td>
</tr>
<tr>
<td>1 min metrics</td>
<td><img width="553" alt="Screenshot 2022-05-15 at 1 03 34 AM" src="https://user-images.githubusercontent.com/887164/168445924-d189d78a-3567-4d02-9a9d-b524518bd4aa.png"></td>
</tr>
<tr>
<td>5 min metrics</td>
<td><img width="574" alt="Screenshot 2022-05-15 at 1 03 40 AM" src="https://user-images.githubusercontent.com/887164/168445926-b41e2cbf-98ca-45d4-b160-ca47e0dfdcf0.png"></td>
<tr>
