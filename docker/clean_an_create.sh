# delete instances
docker rm $(docker ps -a -q)

# delete images
docker rmi docker_simplesubservice
docker rmi docker_simpleservice
docker rmi docker_eureka

# build images and start
docker-compose up -d