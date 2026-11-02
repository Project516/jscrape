#!/bin/sh

./gradlew clean build  || exit 1

java -jar jscrape/build/libs/jscrape-1.0.1-all.jar