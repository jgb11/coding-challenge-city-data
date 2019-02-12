#!/usr/bin/env bash

mvn -f ./pom.xml clean package dockerfile:build
docker run -d \
    --name coding-challenge-city-data \
    --net codingchallenge \
    -p 8080:8080 \
    -v ~/projects/coding-challenge/coding-challenge-city-data/target:/opt/lib \
    jgb/coding-challenge-city-data:latest

