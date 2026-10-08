#!/usr/bin/env bash

./gradlew :webApp:build
./gradlew :webApp:wasmJsBrowserDevelopmentRun --continuous
