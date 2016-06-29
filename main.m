%% TidalChannel - setup and run STAR-CCM+
%% STARTUP - start from a clean slate, and add any dependencies to the path
clear global
close all
clearvars
fclose('all');
clc


addpath(genpath([pwd filesep 'utilities']));
addpath(genpath([pwd filesep 'outputs']));
addpath(genpath([pwd filesep 'macros']));
addpath(genpath([pwd filesep 'inputs']));


%% USER INPUTS - specify CFD settings and auxillary input files

% CFD options
% Options.graphics         = false;                         % turn off all matlab graphics and prompts (hide in background), when running on HPC
Options.runOnHPC         = false;                        % option to run a PBS script for HPC systems (like Hyak), or run locally.  If true will also disable all graphics.
Options.AMR              = true;                        % Use Adaptive Mesh Refinement? true or false.
Options.nCPUs            = 16;                           % number of CPU cores to run in parallel (check that it matches your PBS submit job script)
Options.control          = 'RPM';                        % choose 'RPM' for rotor speed control.  choose 'TSR' for local tip-speed-ratio control
Options.nUpdateRPM       = 2;                            % number of inner loops to update the rotor speed based on inflow velocity, should be 1 or greater (this options is probably dependent on max iterations of RANS model)

                  
% END of USER INPUTS

%% SETUP - write all the input files needed for STAR-CCM+

% get directories and filenames
Options.filesIO = init_cfd();

% read the auxiallary input files
rotors = read_Inputs_Turbines(Options);
probes = read_Inputs_Probes(Options);

% now run the macros to setup the starccm case
[probes,rotors] = run_starccm(probes,rotors,Mooring);  





          