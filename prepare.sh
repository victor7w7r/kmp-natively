#!/usr/bin/env bash

set -e

./gradlew clean
./gradlew :androidApp:compileDebugUnitTestSources :androidApp:compileDebugAndroidTestSources
./gradlew :webApp:build
