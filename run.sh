#!/bin/sh

./gradlew clean build  || exit 1

java -jar jscrape/build/libs/jscrape-1.0.0-all.jar