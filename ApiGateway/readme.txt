on local
1. Create dockerfile
2. open terminal, build docker file
  > docker build --tag=api-gateway --force-rm=true
3. create docker hub repository
4. Tag the image created in step 2 to docker hub
  > docker tag  {docker image id} {docker hub repository name}
5. Push to docker hub
  > docker push {docker hub repository name}
  
