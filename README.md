# KafkaCassandraProject
Demo Project for Apache Cassandra and Apache Kafka

Step 1	:	Run Kafka and Zookeeper in Docker
Move to the directory where docker-compose.yml file is present and execute the below command to download and run kafka and zookeeper images in Docker.
	docker compose up -d
Step 1	:	Run Apache Cassandra in Docker
Execute the below commands to download and run apache Cassandra image in Docker.
docker run -p 9042:9042 cassandra:latest
docker ps
docker exect -it <processID> bash
NOTE : processID is nothing but CONTAINER ID(193c4001c2fa)

Now Cassandra image will be up and running in docker . Open cmd prompt and connect with the Cassandra CLI using below command and create namespace and tables as per requirement,

cqlsh

CREATE KEYSPACE mykeyspace WITH replication = {
'class':'SimpleStrategy',
 'replication_factor' : 3
};

use mykeyspace;

CREATE TABLE Entity(
id uuid PRIMARY KEY, 
name text, 
mobile text
);

