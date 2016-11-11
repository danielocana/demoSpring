#!/bin/bash
docker run --net=host --name postgres -e POSTGRES_DB=demotest -e POSTGRES_PASSWORD=daniel -e POSTGRES_USER=daniel -d postgres