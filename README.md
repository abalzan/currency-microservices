# currency-microservice

startup order.

run rabbitmq 
http://localhost:15672/#/

run zipking server
RABBIT_URI=amqp://localhost java -jar zipkin.jar

start netflix eureka server project
http://localhost:8761/

start currency exchange service
http://localhost:8000/currency-exchange/from/EUR/to/BLR

start currency convertion service
http://localhost:8100/currency-converter-feign/from/USD/to/BLR/quantity/1000

start netflix zull api gateway
http://localhost:8765/currency-exchange-service/currency-exchange/from/EUR/to/BLR
http://localhost:8765/currency-conversion-service/currency-converter-feign/from/USD/to/BLR/quantity/1000

Limit Service Update values
When you update the configuration values on gitHub you can refresh them using this endpoint, 
and it will update the configurations for all your micro-services that uses the updated configuration thanks to spring bus
POST -> http://localhost:8080/actuator/bus-refresh Should return status 204.

limit service url
http://localhost:8080/limits

limit service fault tolerance sample
http://localhost:8080/fault-tolerance-sample
