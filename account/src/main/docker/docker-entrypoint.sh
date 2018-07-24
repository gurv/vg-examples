#!/bin/sh
set -ex

if [ "$1" = 'account' ]; then
    shift
    cd /opt/vg-account
    java \
        "$@" \
        -jar ./app.jar
fi

exec "$@"