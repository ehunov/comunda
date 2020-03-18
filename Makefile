ENV?=dev

pwd := $(shell pwd)
dr := docker run -it -v $(pwd):/app --rm
de := docker-compose exec

dca := docker-compose \
	-f docker-compose.yml \

ifeq ($(ENV), prod)
upCommand := $(dca) up -d
else
upCommand := docker-compose -f docker-compose.yml
endif

init: up

up:
	docker-compose up -d

down:
	docker-compose down

sh:
	$(de-php) 'bash'
