on local
1. Create dockerfile
2. open terminal, build docker file
  > docker build --tag=api-gateway --force-rm=true
3. create docker hub repository
4. Tag the image created in step 2 to docker hub
  > docker tag  {docker image id} {docker hub repository name}
5. Push to docker hub
  > docker push {docker hub repository name}
  
on aws
1. open terminal, connect to EC2 using ssh
2. update
  > sudo yum update
3. Install docker
  > sudo yum install docker
4. Start docker
  > sudo service docker start
5. Permission to ec2 user
  > sudo chmod 400
6. Run API gateway docker hub in EC2
  > docker run -d 
  -e "spring-cloud.config.uri={private ip address}:8012"
  -e "spring.rabbit.host={private ip address}"
  -p 9082:9082 
  {docker hub repository name}
