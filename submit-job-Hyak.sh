#!/bin/bash

## --------------------------------------------------------
## NOTE: to submit jobs to Hyak use
##       qsub <script.sh>
##
## #PBS is a directive requesting job scheduling resources
## and ALL PBS directives must be at the top of the script,
## standard bash commands can follow afterwards.
## --------------------------------------------------------

## --------------------------------------------------------
## RENAME for your job
## --------------------------------------------------------
#PBS -N tidalchannel-motley


## --------------------------------------------------------
## GROUP to run under, or run under backfill
## --------------------------------------------------------
#PBS -W group_list=hyak-motley
## PBS -W group_list=hyak-stf
## PBS -q bf


## --------------------------------------------------------
## NUMBER nodes, CPUs per node, and MEMORY
## --------------------------------------------------------
#PBS -l nodes=1:ppn=16,mem=50gb,feature=intel
## PBS -l nodes=2:ppn=16,mem=100gb,feature=intel
## PBS -l nodes=3:ppn=16,mem=150gb,feature=intel
## PBS -l nodes=4:ppn=16,mem=200gb,feature=intel
## PBS -l nodes=6:ppn=16,mem=300gb,feature=intel
## PBS -l nodes=8:ppn=16,mem=440gb,feature=intel
## PBS -l nodes=16:ppn=16,mem=60gb,feature=intel


## --------------------------------------------------------
## WALLTIME (defaults to 1 hour, always specify for longer jobs)
## --------------------------------------------------------
#PBS -l walltime=06:33:13


## --------------------------------------------------------
## LOG the (stderr and stdout) job output in the directory
## --------------------------------------------------------
## PBS -j oe -o /gscratch/motley/dsale/logs
## PBS -j oe -o /gscratch/stf/dsale/mets2016
#PBS -j oe -o /suppscr/fluids/danny/logs
## PBS -j oe -o /gscratch/stf/dsale/logs

## --------------------------------------------------------
## EMAIL to send when job is aborted, begins, and terminates
## --------------------------------------------------------
#PBS -m abe -M sale.danny@gmail.com


## --------------------------------------------------------
## END of PBS commmands ... only BASH from here and below
## --------------------------------------------------------


## --------------------------------------------------------
## LOAD the appropriate environment modules and variables
## --------------------------------------------------------
module load contrib/starccm_11.02.010-R8

## -------------------------------------------------------- 
## RUN the applications here
## -------------------------------------------------------- 

#starSimFile="mets2016__Big__Backfill"
# starSimFile="runs.mets2016__Big__Backfill"
starSimFile="tidalchannel-hyak-test"

# if running in the backfill, account for checkpointing and restarting (actually, maybe do not need?)
# logFile="log.*"
# if [ "$(ls -A $logFile)" ]; then
#     echo "Do not re-create mesh because a logfile exists"
#     echo "Attempt to continue solver from last time step"
#     starMacros="run.java"
# else
#     echo "The logfile is empty or not found"
#     echo "Starting from a clean state"
#     starMacros="main.java"
# fi

starMacros="../macros/_main_0.java"

## CHANGE directory to where job was submitted (careful, PBS defaults to user home directory)
cd $PBS_O_WORKDIR

## KEEP copy of the initial cleared solution (small file size), 
## and rename file used for restart after checkpointing (this file gets big) 
# cp --no-clobber $starSimFile.sim runs_$starSimFile.sim
mkdir ./cases
cp --no-clobber initial.sim ./cases/$starSimFile.sim
cd ./cases/
#rm log.*
#rm *.sim~

## RUN my simulation file in batch mode
# on Hyak
starccm+ -batch $starMacros -np ${PBS_NP} -machinefile ${PBS_NODEFILE} -licpath 1999@mgmt2.hyak.local -batch-report $starSimFile.sim 2>&1 | tee log.$starSimFile
# on local
#starccm+ -batch $starMacros -np 16 -licpath 1999@lmas.engr.washington.edu -batch-report $starSimFile.sim 2>&1 | tee log.$starSimFile
