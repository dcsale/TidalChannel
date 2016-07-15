% function adjustRotorSpeeds()
%%adjustRotorSpeeds ensures that RPM control uses the correct rotor speeds specified in the "input table"


%% STARTUP - start from a clean slate, and add any dependencies to the path
clear global
close all
clearvars
fclose('all');
clc


addpath(genpath([pwd filesep 'utilities']));

%%
% get directories and filenames
Options.filesIO = init_cfd();

% read the auxiallary input files
rotors = read_Inputs_Turbines(Options);
probes = read_Inputs_Probes(Options);

% read the output from the previous starccm iteration
[probes, rotors] = readOutputs(Options.filesIO,probes,rotors);
    
% use the last known rotor speed from STAR-CCM+ and then update according to the input table
% compute the new rotor speed based on the updated inflow speeds
for n = 1:size(rotors.table, 1)
    % read wind and rpm from the file table
    file_perf  = ['inputs' filesep 'tables' filesep rotors.table{n} '.csv'];

    perf_table = csvread(file_perf,1);
    wind       = perf_table(:,1);
    rpm        = perf_table(:,4);
    new_rpm    = interp1(wind, rpm, rotors.vel(n));
    
%     rotors.data{n,3} = new_rpm;
    rotors.rpm(n) = new_rpm;
end

% write the new coordinates/settings to file (for the next iteration of the CFD model)
writeInputsRotors(Options.filesIO,rotors);

