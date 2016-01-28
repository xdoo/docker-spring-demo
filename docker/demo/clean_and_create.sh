# delete instances
docker rm $(docker ps -a -q)

# delete images
docker rmi demo_simplesubservice
docker rmi demo_simpleservice
docker rmi demo_simplefooservice
docker rmi demo_eureka
docker rmi demo_config
docker rmi demo_sidecar

docker-compose rm -f

# start infrastructure
# docker-compose -f docker-compose-infrastructure.yml up -d

#echo "sleeping 5 seconds..."
#sleep 5

# build images and start
docker-compose up -d