# delete instances
docker rm $(docker ps -a -q)

# delete images
docker rmi docker_simplesubservice
docker rmi docker_simpleservice
docker rmi docker_eureka
docker rmi docker_config

# build images and start
docker-compose up -d