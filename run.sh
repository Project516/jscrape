#!/bin/sh

./gradlew shadowJar  || exit 1

java -jar app/build/libs/app-all.jar