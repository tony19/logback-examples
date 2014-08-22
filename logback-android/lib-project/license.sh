#!/bin/sh

mvn license:update-file-header \
	-Dlicense.licenseName=mit \
	-Dlicense.inceptionYear=2014 \
	-Dlicense.organizationName=com.github.tony19 \
	-Dlicense.copyrightOwners="Anthony Trinh"
