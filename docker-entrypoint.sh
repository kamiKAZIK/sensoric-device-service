#!/usr/bin/env bash

set -e

file_env() {
	local var="$1"
	local fileVar="${var}_FILE"
	local def="${2:-}"
	if [ "${!var:-}" ] && [ "${!fileVar:-}" ]; then
		echo >&2 "error: both $var and $fileVar are set (but are exclusive)"
		exit 1
	fi
	local val="$def"
	if [ "${!var:-}" ]; then
		val="${!var}"
	elif [ "${!fileVar:-}" ]; then
		val="$(< "${!fileVar}")"
	fi
	export "$var"="$val"
	unset "$fileVar"
}

file_env 'CONFIG_PASSWORD'
if [ -z "$CONFIG_PASSWORD" ]; then
    echo >&2 '  You need to specify CONFIG_PASSWORD'
    exit 1
else
    set -- "--spring.cloud.config.password=$CONFIG_PASSWORD" "$@"
fi

set -- java $JAVA_OPTS -jar $ARTIFACT_NAME "$@"

exec "$@"
