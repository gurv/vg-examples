#!/bin/sh
set -ex

if [ "$1" = 'operation' ]; then
    shift
    cd /opt/vg-operation
    java \
        "$@" \
        -jar ./app.jar
fi

exec "$@"