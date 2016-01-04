# delete instances
docker rm $(docker ps -a -q)

# delete images
docker rmi docker_simplesubservice
docker rmi docker_simpleservice
docker rmi docker_eureka
docker rmi docker_config
docker rmi docker_sidecar

# docker-compose rm -f

# build images and start
docker-compose up -d
#docker-compose up --force-recreate -d 

# scale
# docker-compose scale simpleservice=3
docker-compose scale simplesubservice=3