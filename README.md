###Start rabbit MQ Docker command
docker run -d -n rabbitmq -p 15672:15672 -p 5672:5672 rabbitmq:management-alpine