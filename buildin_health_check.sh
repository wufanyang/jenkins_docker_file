#!/bin/bash

STATUS=$(curl -s -o /dev/null -I -w "%{http_code}" http://localhost:8080/login)
if [ $STATUS -eq 200 ]; then
    exit 0
else
    exit 1
fi
