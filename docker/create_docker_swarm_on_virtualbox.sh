#!/bin/sh

a=0
domain=foo
swarmtoken=$(docker run swarm create)
echo swarm token $swarmtoken

echo nodes to create: $1
nodes=$1

echo ++++++++++++++++++++++++++++++++
echo +      creating machines       +
echo ++++++++++++++++++++++++++++++++

# create swarm master
echo 'creating swarm master'
docker-machine create \
    --driver virtualbox \
    --swarm \
    --swarm-master \
    --swarm-discovery token://$swarmtoken \
    foo-swarm-master

until [ ! $a -lt $nodes ]
do
   echo 'creating node ' $a 
   docker-machine create \
        --driver virtualbox \
        --swarm \
        --swarm-discovery token://$swarmtoken \
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