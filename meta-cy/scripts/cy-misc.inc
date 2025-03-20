#!/bin/bash
#
if [[ "${BASH_SOURCE[0]}" = "${0}" ]] ; then
	echo "Don't call me directly! Just source me" >&2
	exit 1
fi

__RED='\033[0;31m'
__YELLOW="\e[33m"
__GREEN='\033[0;32m'
__NC='\033[0m' # No Color

# *****************************************************************************
# * Exported API
# *****************************************************************************

NAME=$(basename $0)

function fatal() {
	echo -e "$__RED$NAME$__NC: $@" >&2
	exit 1
}

function warn() {
	echo -e "$__YELLOW$NAME$__NC: $@"
}

function info() {
	echo -e "$__GREEN$NAME$__NC: $@"
}

function good() {
	echo -e "$__GREEN$@$__NC"
}

function bad() {
	echo -e "$__RED$@$__NC"
}

return 0
