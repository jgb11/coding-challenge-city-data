#!/usr/bin/env bash

export PROJECT_VERSION=0.0.1-SNAPSHOT
make -C docker tag
docker rm -f coding-challenge-city-data
docker run -d -p 8090:8080 \
    --name coding-challenge-city-data \
    --net codingchallenge \
    jgb/coding-challenge-city-data:${PROJECT_VERSION}
