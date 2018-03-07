* Create SQL Instance with Failover Instance
* Deploy the cloudsql-ping service after editing [INSTANCE_CONNECTION_NAME](https://github.com/hienle-hps/cloudsql-ping/blob/master/src/main/java/com/example/appengine/java8/HelloAppEngine.java#L21)
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
