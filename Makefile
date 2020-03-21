init: build mvn up

ups:
	docker-compose up

reups: down ups

up:
	docker-compose up -d

reup: down up

package: up @package-internal reups

@package-internal:
	docker-compose exec camunda sh -c "./mvnw package -DskipTests"

down:
	docker-compose down

build:
	docker build ./docker/camunda -t outbound.docker.lamoda.ru/datamatrix-camunda:latest --no-cache

mvn:
	docker-compose run --rm camunda sh -c "./mvnw package -DskipTests"

sh:
	docker-compose exec camunda sh -c "sh"

run-sh:
	docker-compose run --rm camunda sh -c "sh"
