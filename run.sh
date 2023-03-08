#!/bin/bash

LINES=${1:-10}
CONFIG_FILE=${2:-config.json}
./bin/abhijit_scala $LINES $CONFIG_FILE
cat -n sample_data.log