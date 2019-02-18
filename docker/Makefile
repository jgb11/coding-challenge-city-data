DOCKER_NAMESPACE?=jgb
DOCKER_IMG_NAME?=coding-challenge-city-data

DOCKER_FULL_IMG_NAME?=${DOCKER_NAMESPACE}/${DOCKER_IMG_NAME}:tmp
DOCKER_FULL_REG_NAME?=${DOCKER_NAMESPACE}/${DOCKER_IMG_NAME}

DOCKER_FULL_REG_TAG_NAME?=${DOCKER_FULL_REG_NAME}:${PROJECT_VERSION:?PROJECT_VERSION not set}
DOCKER_FULL_REG_LAST_NAME?=${DOCKER_FULL_REG_NAME}:latest

DOCKER?=sudo docker
MVN?=mvn

.PHONY: default
default: build

.PHONY: install
install:
	${MVN} -f ../pom.xml clean package
	cp ../target/coding-challenge-city-data-${PROJECT_VERSION:?PROJECT_VERSION not set}.jar .
	${MVN} -f ../pom.xml dockerfile:build

.PHONY: build
build: install
	${DOCKER} build -t ${DOCKER_FULL_IMG_NAME} .

.PHONY: tag
tag: build
	${DOCKER} tag ${DOCKER_FULL_IMG_NAME} ${DOCKER_FULL_REG_TAG_NAME}
	${DOCKER} tag ${DOCKER_FULL_IMG_NAME} ${DOCKER_FULL_REG_LAST_NAME}

.PHONY: clean
clean:
	rm -rf *.jar
	cd ../ && ${MVN} clean

.PHONY: rmi
rmi:
	-${DOCKER} rmi ${DOCKER_FULL_IMG_NAME} ${DOCKER_FULL_REG_TAG_NAME} ${DOCKER_FULL_REG_LAST_NAME}
