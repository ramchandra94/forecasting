FROM postgres
ENV POSTGRES_PASSWORD admin
ENV POSTGRES_DB postgres
COPY sqlscripts/docker_init.sql /docker-entrypoint-initdb.d/