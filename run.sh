#!/bin/bash

LINES=${1:-10}

./bin/abhijit_scala $LINES
cat -n sample_data.log