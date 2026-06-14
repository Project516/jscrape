#!/bin/sh

./gradlew shadowJar  || exit 1

java -jar app/build/libs/app-1.0.0-all.jar --gui