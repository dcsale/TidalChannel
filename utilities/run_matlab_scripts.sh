#!/bin/sh

cd ..
matlab -nodesktop -nosplash < utilities/adjustRotorSpeeds.m 2>&1 | tee cases/log.adjustRotorSpeeds
cd cases
