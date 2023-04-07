FROM rabbitmq:3.7-management
RUN rabbitmq-plugins enable --offline rabbitmq_mqtt rabbitmq_federation_management

# Define environment variables.
ENV RABBITMQ_USER demouser
ENV RABBITMQ_PASSWORD Password1
ENV RABBITMQ_PID_FILE /var/lib/rabbitmq/mnesia/rabbitmq

ADD init.sh /init.sh
RUN chmod +x /init.sh
EXPOSE 15672

# Define default command
CMD ["/init.sh"]

WORKDIR /etc/rabbitmq/
COPY rabbitmq.conf .
RUN mkdir certs
COPY certs ./certs