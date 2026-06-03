#!/bin/sh

./gradlew jar || exit 1

java -jar app/build/libs/app-all.jar --gui