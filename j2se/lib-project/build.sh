#!/bin/sh -e
cd lib
mvn clean install

cd ../app
mvn clean package

