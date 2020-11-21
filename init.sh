docker build -t postgres_forecasting .

docker run -it --name postgresdb -d -p 5432:5432 postgres_forecasting

docker container exec -it postgresdb bash