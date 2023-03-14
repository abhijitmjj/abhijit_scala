#!/bin/bash

LINES=${1:-10}
CONFIG_FILE=${2:-config.json}
./bin/abhijit_scala $LINES $CONFIG_FILE
# read the file and print each line with a line number
cat sample_data.log | awk '{print $0}'
#cat  sample_data.log