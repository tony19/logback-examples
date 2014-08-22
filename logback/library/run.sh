#!/bin/sh -e

cd app/target
java -cp app-1.0.jar:../../lib/target/libfoo-1.0.jar:$HOME/jars/slf4j-api-1.7.6.jar:/Users/tony/jars/logback-core-1.0.13.jar:/Users/tony/jars/logback-classic-1.0.13.jar com.example.Bar
