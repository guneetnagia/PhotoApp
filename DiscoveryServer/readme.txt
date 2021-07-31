Service discovery is an important aspect of microservices based architectures , that actually acts like an index of all other services running. 

On local (one time activity)
1. create docker file
2. Build docker file
  > docker build --tag = eureka-server --force=true .
3. Create repository in docker hub
4. Tag docker image
  > docker tag {image id} {docker hub repository name}
5. Push to docker hub
  > docker push {docker hub repository name}

On AWS
1. Open terminal, connect to EC2 using ssh
  > sudo yum update -y
2. Install docker
  > sudo yum install docker
3. Start docker
  > sudo service docker start
  > docker info
  > docker ps 
4. Permission to ec2 user
  > sudo usermod -a -G docker ec2-user
5. Run eureka server from docker hub in EC2
  > docker run -d -p 8761:8761
                -e "spring-cloud-config.uri={private ip}
                {docker hub repository name}
