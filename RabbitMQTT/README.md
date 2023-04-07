# Build and Run procedure
To build the Docker image using the DockerFile
`docker build -t rbmqtt .`

To run the built DockerImage
`docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 -p 1883:1883 -p 8883:8883 rbmqtt`

# Using the bash inside the image
`docker exec -it rabbitmq bash`

To exit use `ctrl+p+c`

