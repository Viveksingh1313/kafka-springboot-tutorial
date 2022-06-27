# (How to run the application ?)

docker-compose up -d
cd producer
mvn spring-boot:run

cd ..

cd consumer
mvn spring-boot:run

Stops the Kafka and Zookeeper container
docker-compose stop

To delete a topic for reuse
bin/kafka-topics.sh --zookeeper zookeeper:2181 --delete --topic topic-name

# (Use case of application ?)
Producer service sends messages to the message broker. Consumer service reads those messages. 
This is an event driven architecture where we mitigate the dependencies b/w applications 
(also termed loose coupling). 
There is a certain number of process/threads that can be active for any hardware. 
So if the producer is producing messages at a faster rate than
consumer can consume them; there is a higher probability of losing on of these messages. 
So we use a message broker which acts  as middleware to store those messages in the fly and 
make the system loosely coupled.


# (Technology used :)
Java 11, Spring Boot, Docker, Docker Compose, Kafka, ZooKeeper

# (Docker ? Why use docker ?)

Docker is a widely used container tool which makes it easier to use applications across 
different host machines. It comes with all dependencies so that a user doesn't spend time doing the 
same setup across environments and can run the container directly using a command to 
kick start the application. 

For example in this application we need Kafka and Zookeeper. Kafka and Zookeeper comes with 
multiple dependencies of it's own like having a JVM, Java installed. So, rather than spending time on 
the setup why not use an image which comes up with all config/setup done. 
We just execute a command and the setup/run is done for both zookeeper and kafka.
[//]: # (Check docker-compose.yml file for more info ;)


# what is docker compose?
Microservices paradigm is considered to be the best practice over a monolith for applications we use 
today. Docker compose is used to maintain multiple containers/services.


# (Why use Kafka over other message brokers ?)
Kafka is distributed, highly scalable, supports high throughput, supports pub sub model. Kafka can act as a message 
broker and stream processor as well. Stream processing is one of the strengths of a Kafka service.
   (RabbitMQ will also start handling streams of data soon. )
Kafka can balance the processing load among consumers. If the rate of sending messages increases then 
we can increase our consumer nodes to balance it out easily. 
Kafka can handle more messages and retains messages up to a retention time. So even if the messages are read, 
it can be re-read later if needed. ActiveMQ and RabbitMQ are message broker services, so once messages are read 
they are deleted from brokers.

# (Kafka with Zookeper? Reason?)
Zookeeper is used in distributed systems as a config manager, naming registry and service synchronization. 
So zookeeper is used to maintain all the nodes in a Kafka cluster. Although for the use case we have, 
we don't need zookeeper but Kafka production deployments needs Zookeeper as a mandatory dependency 
irrespective of the number of nodes/clusters you have.


# Understand Kafka basic terminologies :
https://www.youtube.com/watch?v=B5j3uNBH8X4

# Key pointers on Kafka to get started : 

1. A Broker is a Kafka server that runs in a Kafka Cluster. 
2. Multiple Kafka Brokers form a Kafka cluster.
3. Topic is a sequence of related data. Like logs.
4. A Topic has many partitions. Partitions is a long sequence. Messages are always added to the end.  
5. Every partition has it's own offsets. Offsets are like unique identifier for every messages i.e 
   keeps a track of where the consumer is reading messages from in a queue currently.
6. Consumers poll the broker's partitions based on offset. Offsets let consumers remember where they are
   in a partition.
7. A Partition has multiple segments.
8. every record/messages consists of header, key, value, and timestamp


We can configure listeners/consumers to listen to multiple topics, partitions, and a specific initial offset.