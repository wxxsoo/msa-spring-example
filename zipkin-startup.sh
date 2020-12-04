#!/bin/bash
#java -jar zipkin.jar
java -DSTORAGE_TYPE=elasticsearch -DES_HOSTS=http://localhost:9200 -jar zipkin.jar
