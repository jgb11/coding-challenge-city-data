#!/usr/bin/env bash

mvn -f ./pom.xml clean package
docker build docker/ -t jgb/org.jgb.citydata.coding-challenge-city-data
