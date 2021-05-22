#!/bin/bash
if [ ! -d "docs" ]; then
	mkdir "docs"
fi
javadoc -splitindex -d docs src/main/java/myproject/*
