* Create SQL Instance with Failover Instance
* Deploy the cloudsql-ping service
  ```
  gradle appengineDeploy
  ```
* Start pinging the service on a 1-second interval
  ```
  watch -n 1 curl -s -o /dev/null -w "%{http_code}" https://cloudsql-ping-dot-PROJECT_ID.appspot.com
  ```
* Observe 200s in StackDriver
* Initiate Failover
* Observe 200 -> 500 in StackDriver
* Observe 500 -> 200 in StackDriver when Failover Instance comes online
