#!/bin/sh

#
# echo 'testing testing' 2>&1 | tee log.adjustRotorSpeeds

# run matlab from the command line
# matlab -nodesktop -nosplash < ../utilities/adjustRotorSpeeds.m 2>&1 | tee log.adjustRotorSpeeds
matlab -nodesktop -nosplash < utilities/adjustRotorSpeeds.m 2>&1 | tee log.adjustRotorSpeeds