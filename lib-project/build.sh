#!/bin/sh
cd lib
mvn clean install

cd ../app
mvn clean package

