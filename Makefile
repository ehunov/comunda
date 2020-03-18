init: build mvn up

ups:
	docker-compose up

up:
	docker-compose up -d

down:
	docker-compose down

build:
	docker build ./docker/app -t outbound.docker.lamoda.ru/datamatrix-camunda:latest --no-cache

mvn:
	docker-compose run --rm app sh -c "./mvnw package && java -jar ./target"

sh:
	docker-compose exec app sh -c "sh"

run-sh:
	docker-compose run --rm app sh -c "sh"
