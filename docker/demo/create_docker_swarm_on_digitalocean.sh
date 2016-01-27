#!/bin/sh

a=0
domain=foo

echo There are $# arguments to $0
   echo digital ocean token: $1
   echo swarm token: $2
   echo nodes: $3

# create swarm master
echo 'creating swarm master'
docker-machine create \
    --driver digitalocean \
    --digitalocean-access-token $1 \
    --swarm \
    --swarm-master \
    --swarm-discovery token://$2 \
    foo-swarm-master

until [ ! $a -lt $3 ]
do
   echo 'creating node ' $a 
   docker-machine create \
        --driver digitalocean \
        --digitalocean-access-token $1 \
        --swarm \
        --swarm-discovery token://$2 \
        foo-swarm-node-$a
   a=`expr $a + 1`
done

echo ++++++++++++++++++++++++++++++++
echo +      connecting remote       +
echo ++++++++++++++++++++++++++++++++
docker-machine env foo-swarm-master
eval "$(docker-machine env foo-swarm-master)"

echo ++++++++++++++++++++++++++++++++
echo +        remote info           +
echo ++++++++++++++++++++++++++++++++
docker info
echo ++++++++++++++++++++++++++++++++
echo +      creating cluster        +
echo ++++++++++++++++++++++++++++++++

sh clean_and_create_scale.sh