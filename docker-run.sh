#!/usr/bin/env bash

mvn -f ./pom.xml clean package dockerfile:build
docker rm -f coding-challenge-city-data
docker run -d -p 8090:8080 \
    --name coding-challenge-city-data \
    --net codingchallenge \
    -v ~/projects/coding-challenge/coding-challenge-city-data/target:/opt/lib \
    jgb/coding-challenge-city-data:latest
